package com.circlein.socialcrawler.api.webpage.words.counter;

import org.springframework.stereotype.Service;

@Service
public class WebpageWordCounter {

    public WordCountResponse count(WordCountRequest wordCountRequest) {
        return new WordCountResponse(10);
    }

}
