package com.circlein.socialcrawler.api.webpage.content.reader;

import com.circlein.socialcrawler.api.error.ErrorEntry;
import com.circlein.socialcrawler.api.error.ErrorHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.circlein.socialcrawler.api.error.ErrorEntry.UPSTREAM_UNAVAILABLE;

@Repository
public class WebpageContentReader {

    private final HttpClientCreator httpClientCreator;

    public WebpageContentReader(HttpClientCreator httpClientCreator) {
        this.httpClientCreator = httpClientCreator;
    }

    public String read(String url) {
        try {
            HttpClient client = create();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw throw502GatewayUnavailableHttpError(e);
        }
    }

    private WebClientResponseException throw502GatewayUnavailableHttpError(Exception e) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        ErrorHolder errorHolder = new ErrorHolder();
        ErrorEntry errorEntry = new ErrorEntry(UPSTREAM_UNAVAILABLE, "something went wrong when attempting to fetch HTML cod from the url");
        errorHolder.add(errorEntry);
        return WebClientResponseException.create(
                502,
                "Bad Gateway",
                httpHeaders, errorHolder.asByteArray(), null);
    }

    private HttpClient create() {
        return httpClientCreator.create();
    }

}
