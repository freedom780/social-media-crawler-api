package com.circlein.socialcrawler.api.common;

import com.circlein.socialcrawler.SocialcrawlerApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest(classes = {SocialcrawlerApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestControllerTest {

    @LocalServerPort
    private int port;

    protected WebClient createWebClient() {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:" + port)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        return webClient;
    }

}