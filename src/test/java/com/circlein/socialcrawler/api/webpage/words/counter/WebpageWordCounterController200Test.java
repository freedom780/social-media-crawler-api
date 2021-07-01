package com.circlein.socialcrawler.api.webpage.words.counter;

import com.circlein.socialcrawler.api.webpage.words.counter.model.WordCountResponse;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class WebpageWordCounterController200Test extends WebpageWordCounterControllerTest {

    @Test
    public void return200ResponseWithValidHttpUrlAndValidWord() {

        // setup fixture
        WebClient webClient = createWebClient();
        String validRequest = jsonResponseReader.read("webpage/words/counter/valid/valid-request-with-http-url.json");

        // exercise SUT
        WordCountResponse response = consumeWordCountApi(webClient, validRequest);

        // verify
        assertThat(response, is(not(nullValue())));
    }

    @Test
    public void return200ResponseWithValidHttpsUrlAndValidWord() {

        // setup fixture
        WebClient webClient = createWebClient();
        String validRequest = jsonResponseReader.read("webpage/words/counter/valid/valid-request-with-https-url.json");

        // exercise SUT
        WordCountResponse response = consumeWordCountApi(webClient, validRequest);

        // verify
        assertThat(response, is(not(nullValue())));
    }

}