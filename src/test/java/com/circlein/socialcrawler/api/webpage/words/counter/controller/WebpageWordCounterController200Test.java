package com.circlein.socialcrawler.api.webpage.words.counter.controller;

import com.circlein.socialcrawler.api.webpage.words.counter.model.WordCountResponse;
import com.circlein.socialcrawler.api.webpage.words.counter.service.WebpageContentReader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.reactive.function.client.WebClient;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class WebpageWordCounterController200Test extends WebpageWordCounterControllerTest {

    private static final int FIVE_MATCHES_OF_WORD_MATRIX = 5;

    @MockBean
    private WebpageContentReader webpageContentReader;

    @Test
    public void return200ResponseWithValidHttpUrlAndValidWord() {

        // setup fixture
        WebClient webClient = createWebClient();
        String validRequest = testContentReader.read("webpage/words/counter/json/valid/valid-request-with-http-url.json");
        mockHtmlCodeWithFiveMatchesOfWordMatrix();

        // exercise SUT
        WordCountResponse response = consumeWordCountApi(webClient, validRequest);

        // verify
        verifyFiveMatchesOfWordMatrix(response);
    }

    @Test
    public void return200ResponseWithValidHttpsUrlAndValidWord() {

        // setup fixture
        WebClient webClient = createWebClient();
        String validRequest = testContentReader.read("webpage/words/counter/json/valid/valid-request-with-https-url.json");
        mockHtmlCodeWithFiveMatchesOfWordMatrix();

        // exercise SUT
        WordCountResponse response = consumeWordCountApi(webClient, validRequest);

        // verify
        verifyFiveMatchesOfWordMatrix(response);
    }

    private void mockHtmlCodeWithFiveMatchesOfWordMatrix() {
        String htmlCode = testContentReader.read("webpage/words/counter/html/content-with-5-matrix-words.html");
        when(webpageContentReader.read(any(String.class))).thenReturn(htmlCode);
    }

    private void verifyFiveMatchesOfWordMatrix(WordCountResponse response) {
        assertThat(response, is(not(nullValue())));
        assertThat(response.getNumberOfMatches(), is(FIVE_MATCHES_OF_WORD_MATRIX));
    }
}