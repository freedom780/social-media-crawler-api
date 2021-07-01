package com.circlein.socialcrawler.api.webpage.content.reader;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WebpageContentReaderSuccessfulTest extends WebpageContentReaderTest {

    public static final String URL = "https://google.com";

    @Test
    public void readSuccessfully() throws IOException, InterruptedException {

        // setup fixture
        mockSuccessfulResponse();

        // exercise SUT
        String result = webpageContentReader.read(URL);

        // verify
        assertThat(result, is(not(nullValue())));
    }

    private HttpClient mockSuccessfulResponse() throws IOException, InterruptedException {
        String htmlContent = createSampleHtmlContent();
        HttpResponse<String> response = mockResponseWithContent(htmlContent);
        HttpClient httpClient = mockSuccessfulHttpClientCall(response);
        return httpClient;
    }

    private HttpClient mockSuccessfulHttpClientCall(HttpResponse<String> response) throws IOException, InterruptedException {
        HttpClient httpClient = mock(HttpClient.class);
        when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(response);
        when(httpClientCreator.create()).thenReturn(httpClient);
        return httpClient;
    }

}