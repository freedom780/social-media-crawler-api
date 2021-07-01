package com.circlein.socialcrawler.api.error;

import lombok.Getter;

@Getter
public class ErrorEntry {

    private final String code;
    private final String message;

    public ErrorEntry(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
