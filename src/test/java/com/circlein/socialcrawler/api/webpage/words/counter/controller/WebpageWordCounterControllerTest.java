package com.circlein.socialcrawler.api.webpage.words.counter.controller;

import com.circlein.socialcrawler.api.common.TestContentReader;
import com.circlein.socialcrawler.api.common.RestControllerTest;
import com.circlein.socialcrawler.api.webpage.words.counter.model.WordCountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import static com.circlein.socialcrawler.api.webpage.words.counter.WebpageWordCounterController.WEBPAGE_WORDS_COUNT_REQUEST_URI;

public abstract class WebpageWordCounterControllerTest extends RestControllerTest {

    @Autowired
    TestContentReader testContentReader;

    WordCountResponse consumeWordCountApi(WebClient webClient, String body) {
        return webClient.
                post().
                uri(WEBPAGE_WORDS_COUNT_REQUEST_URI).
                body(BodyInserters.fromValue(body)).
                retrieve().
                bodyToMono(WordCountResponse.class).block();
    }

}
