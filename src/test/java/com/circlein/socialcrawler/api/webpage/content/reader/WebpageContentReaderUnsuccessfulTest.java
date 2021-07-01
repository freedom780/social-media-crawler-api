package com.circlein.socialcrawler.api.webpage.content.reader;


import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WebpageContentReaderUnsuccessfulTest extends WebpageContentReaderTest {

    public static final String URL = "https://aurlthatcantberesolveda.com";

    @Test
    public void returns502BadGatewayErrorWhenAddressUnresolved() throws IOException, InterruptedException {

        // setup fixture
        mockHttpClientCallWithConnectException();

        // exercise SUT + verify
        assertThrows(WebClientResponseException.BadGateway.class, () -> {
            webpageContentReader.read(URL);
        });
    }

    private HttpClient mockHttpClientCallWithConnectException() throws IOException, InterruptedException {
        HttpClient httpClient = mock(HttpClient.class);
        when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenThrow(ConnectException.class);
        when(httpClientCreator.create()).thenReturn(httpClient);
        return httpClient;
    }


}