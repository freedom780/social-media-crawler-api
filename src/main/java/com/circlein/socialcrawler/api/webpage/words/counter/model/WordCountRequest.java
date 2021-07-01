package com.circlein.socialcrawler.api.webpage.words.counter.model;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@ToString
public class WordCountRequest implements Serializable {

    @NotNull(message = "property 'url' cannot be null")
    private String url;

    @NotNull(message = "property 'word' cannot be null")
    private String word;

    public WordCountRequest(String url, String word) {
        this.url = url;
        this.word = word;
    }

}
