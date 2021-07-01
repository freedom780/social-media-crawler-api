package com.circlein.socialcrawler.api.webpage.content.reader;


import com.circlein.socialcrawler.api.common.TestContentReader;

import java.net.http.HttpResponse;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

abstract class WebpageContentReaderTest {

    final HttpClientCreator httpClientCreator = mock(HttpClientCreator.class);
    final WebpageContentReader webpageContentReader = new WebpageContentReader(httpClientCreator);
    final TestContentReader testContentReader = new TestContentReader();


    HttpResponse<String> mockResponseWithContent(String htmlContent) {
        HttpResponse<String> response = mockResponse();
        when(response.body()).thenReturn(htmlContent);
        return response;
    }

    HttpResponse<String> mockResponse() {
        return mock(HttpResponse.class);
    }

    String createSampleHtmlContent() {
        return testContentReader.read("webpage/words/counter/html/content-with-5-matrix-words.html");
    }

}