package com.circlein.socialcrawler.api.webpage.words.counter.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WordCountRequest {

    private final String url;
    private final String word;

    public WordCountRequest(String url, String word) {
        this.url = url;
        this.word = word;
    }

}
