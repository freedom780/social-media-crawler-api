package com.circlein.socialcrawler.api.webpage.words.counter;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebpageWordCounterController {

    private final WebpageWordCounter webpageWordCounter;

    public WebpageWordCounterController(WebpageWordCounter webpageWordCounter) {
        this.webpageWordCounter = webpageWordCounter;
    }

    @PostMapping("/webpage/words/count")
    public WordCountResponse count(@RequestBody WordCountRequest request) {
        return webpageWordCounter.count(request);
    }

}
