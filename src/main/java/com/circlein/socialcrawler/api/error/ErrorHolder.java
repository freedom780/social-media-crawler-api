package com.circlein.socialcrawler.api.error;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
public class ErrorHolder {

    public static final String CANT_BE_BLANK = "0001";
    public static final String INVALID_VALUE = "0002";

    private final Set<ErrorEntry> errors = new LinkedHashSet<>();

    public void add(ErrorEntry entry) {
        errors.add(entry);
    }

    public boolean hasErrors() {
        return errors.size() > 0;
    }

    public byte[] asByteArray() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String errorsAsText = objectMapper.writeValueAsString(this);
            return errorsAsText.getBytes();
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Couldn't convert to JSON string from object", e);
        }
    }

}
