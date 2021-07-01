package com.circlein.socialcrawler.api.webpage.words.counter;

public class WordCountRequest {

    private final String url;
    private final String word;

    public WordCountRequest(String url, String word) {
        this.url = url;
        this.word = word;
    }

    public String getUrl() {
        return url;
    }

    public String getWord() {
        return word;
    }

}
