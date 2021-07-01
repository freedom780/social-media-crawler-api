package com.circlein.socialcrawler.api.webpage.words.counter;

import com.circlein.socialcrawler.api.common.JsonResponseReader;
import com.circlein.socialcrawler.api.webpage.words.counter.model.WordCountResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import static com.circlein.socialcrawler.api.webpage.words.counter.WebpageWordCounterController.WEBPAGE_WORDS_COUNT_REQUEST_URI;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WebpageWordCounterController4xxTest extends WebpageWordCounterControllerTest {

    @Autowired
    private JsonResponseReader jsonResponseReader;

    @Test
    public void return405MethodNotAllowedOnInvalidMethod() {

        // setup fixture
        WebClient webClient = createWebClient();

        // exercise SUT + verify
        assertThrows(WebClientResponseException.MethodNotAllowed.class, () -> {
            consumeWordCountApiUsingInvalidMethod(webClient);
        });
    }

    @Test
    public void return400BadRequestWhenNoUrlSpecified() {

        // setup fixture
        WebClient webClient = createWebClient();
        String requestWithoutWord = jsonResponseReader.read("webpage/words/counter/invalid/invalid-request-missing-url.json");

        // exercise SUT + verify
        assertThrows(WebClientResponseException.BadRequest.class, () -> {
            consumeWordCountApi(webClient, requestWithoutWord);
        });

    }

    @Test
    public void return400BadRequestWhenNoWordSpecified() {

        // setup fixture
        WebClient webClient = createWebClient();
        String requestWithoutWord = jsonResponseReader.read("webpage/words/counter/invalid/invalid-request-missing-word.json");

        // exercise SUT + verify
        assertThrows(WebClientResponseException.BadRequest.class, () -> {
            consumeWordCountApi(webClient, requestWithoutWord);
        });

    }

    @Test
    public void return400BadRequestWhenNeitherUrlNorWordSpecified() {

        // setup fixture
        WebClient webClient = createWebClient();
        String requestWithoutWord = jsonResponseReader.read("webpage/words/counter/invalid/invalid-request-missing-url-and-word.json");

        // exercise SUT + verify
        assertThrows(WebClientResponseException.BadRequest.class, () -> {
            consumeWordCountApi(webClient, requestWithoutWord);
        });

    }

    @Test
    public void return400BadRequestWhenInvalidUrlSpecified() {

        // setup fixture
        WebClient webClient = createWebClient();
        String requestWithoutWord = jsonResponseReader.read("webpage/words/counter/invalid/invalid-request-incorrect-url.json");

        // exercise SUT + verify
        assertThrows(WebClientResponseException.BadRequest.class, () -> {
            consumeWordCountApi(webClient, requestWithoutWord);
        });

    }

    private void consumeWordCountApiUsingInvalidMethod(WebClient webClient) {
        webClient.get().uri(WEBPAGE_WORDS_COUNT_REQUEST_URI).retrieve().bodyToMono(WordCountResponse.class).block();
    }

}
