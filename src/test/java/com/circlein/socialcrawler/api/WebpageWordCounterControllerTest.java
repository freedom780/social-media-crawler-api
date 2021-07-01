package com.circlein.socialcrawler.api;

import com.circlein.socialcrawler.api.webpage.words.counter.WebpageWordCounter;
import com.circlein.socialcrawler.api.webpage.words.counter.WebpageWordCounterController;
import com.circlein.socialcrawler.api.webpage.words.counter.WordCountRequest;
import com.circlein.socialcrawler.api.webpage.words.counter.WordCountResponse;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WebpageWordCounterControllerTest {

    private static final int THREE_MATCHES = 3;
    private static final String VALID_URL = "https://validurl.com";
    private static final String VALID_WORD = "hello";

    WebpageWordCounter webpageWordCounter = mock(WebpageWordCounter.class);

    WebpageWordCounterController webpageWordCounterController = new WebpageWordCounterController(webpageWordCounter);

    @Test
    public void consumeSuccessfully() {

        // setup fixture
        WordCountRequest wordCountRequest = new WordCountRequest(VALID_URL, VALID_WORD);
        when(webpageWordCounter.count(wordCountRequest)).thenReturn(new WordCountResponse(THREE_MATCHES));

        // exercise SUT
        WordCountResponse response = webpageWordCounterController.count(wordCountRequest);

        // verify outcome
        assertThat(response.getNumberOfMatches(), is(THREE_MATCHES));
    }

}
