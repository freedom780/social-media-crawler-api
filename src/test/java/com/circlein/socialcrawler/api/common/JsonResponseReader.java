package com.circlein.socialcrawler.api.common;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class JsonResponseReader {

    public String read(String relativePathToJson) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(relativePathToJson);
            return new String(inputStream.readAllBytes());
        } catch (IOException ex) {
            throw new IllegalStateException("Can't read the test response: " + relativePathToJson, ex);
        }
    }

}
