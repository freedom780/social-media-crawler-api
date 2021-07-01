package com.circlein.socialcrawler.api.webpage.words.counter;

import com.circlein.socialcrawler.api.webpage.words.counter.model.WordCountRequest;
import com.circlein.socialcrawler.api.webpage.words.counter.model.WordCountResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@Validated
public class WebpageWordCounterController {

    public static final String WEBPAGE_WORDS_COUNT_REQUEST_URI = "/webpage/words/count";

    private final WebpageWordCounter webpageWordCounter;

    public WebpageWordCounterController(WebpageWordCounter webpageWordCounter) {
        this.webpageWordCounter = webpageWordCounter;
    }

    @PostMapping(WEBPAGE_WORDS_COUNT_REQUEST_URI)
    public WordCountResponse count(@Valid @RequestBody WordCountRequest request) {
        return webpageWordCounter.count(request);
    }

}
