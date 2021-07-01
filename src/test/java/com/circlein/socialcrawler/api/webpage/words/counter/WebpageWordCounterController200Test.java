package com.circlein.socialcrawler.api.webpage.words.counter;

import com.circlein.socialcrawler.api.webpage.words.counter.model.WordCountResponse;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

public class WebpageWordCounterController200Test extends WebpageWordCounterControllerTest {

    @Test
    public void return200Response() {

        // setup fixture
        WebClient webClient = createWebClient();
        String validRequest = jsonResponseReader.read("webpage/words/counter/valid/valid-request.json");

        // exercise SUT
        WordCountResponse response = consumeWordCountApi(webClient, validRequest);

        // verify
        System.out.println(response);
    }

}