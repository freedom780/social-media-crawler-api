package com.circlein.socialcrawler.api.webpage.words.counter.service;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

@Service
public class HtmlTextWordsExtractor {

    public String[] convert(String htmlCode) {
        String htmlCodeInLowercase = htmlCode.toLowerCase();
        String textWithHtmlTagsRemoved = Jsoup.parse(htmlCodeInLowercase).text();
        String textWithoutPunctuation = textWithHtmlTagsRemoved.replaceAll("\\p{Punct}", " ");
        return textWithoutPunctuation.split("\\s+");
    }

}