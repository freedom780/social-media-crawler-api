package com.circlein.socialcrawler.api.webpage.words.counter;

import com.circlein.socialcrawler.api.error.ErrorEntry;
import com.circlein.socialcrawler.api.error.ErrorHolder;
import com.circlein.socialcrawler.api.webpage.words.counter.model.WordCountRequest;
import com.circlein.socialcrawler.api.webpage.words.counter.model.WordCountResponse;
import com.circlein.socialcrawler.api.webpage.words.counter.service.WebpageWordCounter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import javax.validation.Valid;

import static com.circlein.socialcrawler.api.error.ErrorEntry.CANT_BE_BLANK;
import static com.circlein.socialcrawler.api.error.ErrorEntry.INVALID_VALUE;

@RestController
@Validated
public class WebpageWordCounterController {

    public static final String WEBPAGE_WORDS_COUNT_REQUEST_URI = "/webpage/words/count";

    private final WebpageWordCounter webpageWordCounter;
    private final UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});

    public WebpageWordCounterController(WebpageWordCounter webpageWordCounter) {
        this.webpageWordCounter = webpageWordCounter;
    }

    @PostMapping(WEBPAGE_WORDS_COUNT_REQUEST_URI)
    public WordCountResponse count(@Valid @RequestBody WordCountRequest request) {
        validateRequest(request);
        return webpageWordCounter.count(request);
    }

    private void validateRequest(WordCountRequest request) {
        ErrorHolder errorHolder = new ErrorHolder();
        validateUrlElement(request, errorHolder);
        validateWordElement(request, errorHolder);
        throw400ErrorIfInvalidInput(errorHolder);
    }

    private void validateUrlElement(WordCountRequest request, ErrorHolder errorHolder) {
        if (StringUtils.isBlank(request.getUrl())) {
            ErrorEntry entry = new ErrorEntry(CANT_BE_BLANK, "element 'url' can't be blank");
            errorHolder.add(entry);
        } else {
            if (!urlValidator.isValid(request.getUrl())) {
                ErrorEntry entry = new ErrorEntry(INVALID_VALUE, "invalid URL: " + request.getUrl());
                errorHolder.add(entry);
            }
        }
    }

    private void validateWordElement(WordCountRequest request, ErrorHolder errorHolder) {
        if (StringUtils.isBlank(request.getWord())) {
            ErrorEntry entry = new ErrorEntry(CANT_BE_BLANK, "element 'word' can't be blank");
            errorHolder.add(entry);
        } else {
            if (!StringUtils.isAlphanumeric(request.getWord())) {
                ErrorEntry entry = new ErrorEntry(INVALID_VALUE, "element 'word' can't be a phrase, it must be a single alphanumeric word without spaces");
                errorHolder.add(entry);
            }
        }
    }

    private void throw400ErrorIfInvalidInput(ErrorHolder errorHolder) {
        if (errorHolder.hasErrors()) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Content-Type", "application/json");

            throw WebClientResponseException.create(
                    400,
                    "Bad Request",
                    httpHeaders, errorHolder.asByteArray(), null);
        }
    }

}