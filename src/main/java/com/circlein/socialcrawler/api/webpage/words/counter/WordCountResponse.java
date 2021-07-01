package com.circlein.socialcrawler.api.webpage.words.counter;

public class WordCountResponse {

    private final int numberOfMatches;

    public WordCountResponse(int numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

}
