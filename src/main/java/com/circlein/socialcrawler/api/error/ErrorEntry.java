package com.circlein.socialcrawler.api.error;

import lombok.Getter;

@Getter
public class ErrorEntry {

    public static final String CANT_BE_BLANK = "0001";
    public static final String INVALID_VALUE = "0002";
    public static final String UPSTREAM_UNAVAILABLE = "0003";

    private final String code;
    private final String message;

    public ErrorEntry(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
