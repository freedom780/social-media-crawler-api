package com.circlein.socialcrawler.api.webpage.content.reader;

import org.springframework.stereotype.Component;

import java.net.http.HttpClient;

@Component
public class HttpClientCreator {

    public HttpClient create() {
        return HttpClient.newHttpClient();
    }

}