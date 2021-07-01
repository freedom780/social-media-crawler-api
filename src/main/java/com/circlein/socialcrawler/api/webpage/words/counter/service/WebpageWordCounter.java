package com.circlein.socialcrawler.api.webpage.words.counter.service;

import com.circlein.socialcrawler.api.webpage.content.reader.WebpageContentReader;
import com.circlein.socialcrawler.api.webpage.words.counter.model.WordCountRequest;
import com.circlein.socialcrawler.api.webpage.words.counter.model.WordCountResponse;
import org.springframework.stereotype.Service;

@Service
public class WebpageWordCounter {

    private final WebpageContentReader webpageContentReader;
    private final HtmlTextWordsExtractor htmlTextWordsExtractor;

    public WebpageWordCounter(WebpageContentReader webpageContentReader, HtmlTextWordsExtractor htmlTextWordsExtractor) {
        this.webpageContentReader = webpageContentReader;
        this.htmlTextWordsExtractor = htmlTextWordsExtractor;
    }

    public WordCountResponse count(WordCountRequest wordCountRequest) {
        int numberOfMatches = 0;
        String htmlCode = webpageContentReader.read(wordCountRequest.getUrl());
        String[] words = htmlTextWordsExtractor.convert(htmlCode);
        String wordToMatch = wordCountRequest.getWord().toLowerCase();
        for (String currentWord : words) {
            if (currentWord.equals(wordToMatch)) {
                numberOfMatches++;
            }
        }
        return new WordCountResponse(numberOfMatches);
    }

}
