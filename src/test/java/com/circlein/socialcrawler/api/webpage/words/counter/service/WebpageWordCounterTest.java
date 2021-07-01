package com.circlein.socialcrawler.api.webpage.words.counter.service;

import com.circlein.socialcrawler.api.common.TestContentReader;
import com.circlein.socialcrawler.api.webpage.words.counter.model.WordCountRequest;
import com.circlein.socialcrawler.api.webpage.words.counter.model.WordCountResponse;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WebpageWordCounterTest {

    private static final String URL = "https://TheMatrixMovie.com";
    private static final int FIVE_MATCHES_OF_WORD_MATRIX = 5;
    private static final int ZERO_MATCHES = 0;

    private final TestContentReader testContentReader = new TestContentReader();
    private final WebpageContentReader webpageContentReader = mock(WebpageContentReader.class);
    private final HtmlTextWordsExtractor htmlTextWordsExtractor = new HtmlTextWordsExtractor();
    private final WebpageWordCounter webpageWordCounter = new WebpageWordCounter(webpageContentReader, htmlTextWordsExtractor);

    @Test
    public void countFiveMatchesOfPureWordsWithoutHtmlTagsAndWithoutPunctuation() {

        // setup fixture
        String htmlContent = testContentReader.read("webpage/words/counter/html/content-with-5-matrix-words.html");
        when(webpageContentReader.read(URL)).thenReturn(htmlContent);
        WordCountRequest request = new WordCountRequest(URL, "MaTriX");

        // exercise SUT
        WordCountResponse response = webpageWordCounter.count(request);

        // verify outcome
        assertThat(response.getNumberOfMatches(), is(FIVE_MATCHES_OF_WORD_MATRIX));
    }

    @Test
    public void countNoMatchesOfPureWordsWithoutHtmlTagsAndWithoutPunctuation() {

        // setup fixture
        String htmlContent = testContentReader.read("webpage/words/counter/html/content-with-5-matrix-words.html");
        when(webpageContentReader.read(URL)).thenReturn(htmlContent);
        WordCountRequest request = new WordCountRequest(URL, "NoSuchWordInHtml");

        // exercise SUT
        WordCountResponse response = webpageWordCounter.count(request);

        // verify outcome
        assertThat(response.getNumberOfMatches(), is(ZERO_MATCHES));
    }

}