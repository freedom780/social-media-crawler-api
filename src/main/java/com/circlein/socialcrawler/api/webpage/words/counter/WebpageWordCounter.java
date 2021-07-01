package com.circlein.socialcrawler.api.webpage.words.counter;

import com.circlein.socialcrawler.api.webpage.words.counter.model.WordCountRequest;
import com.circlein.socialcrawler.api.webpage.words.counter.model.WordCountResponse;
import org.springframework.stereotype.Service;

@Service
public class WebpageWordCounter {

    public WordCountResponse count(WordCountRequest wordCountRequest) {
        return new WordCountResponse(10);
    }

}
