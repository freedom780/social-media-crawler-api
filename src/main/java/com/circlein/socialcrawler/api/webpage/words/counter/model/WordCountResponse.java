package com.circlein.socialcrawler.api.webpage.words.counter.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WordCountResponse {

    private int numberOfMatches;

    private WordCountResponse() {
    }

    public WordCountResponse(int numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

}
