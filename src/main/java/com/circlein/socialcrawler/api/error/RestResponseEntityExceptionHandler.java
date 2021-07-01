package com.circlein.socialcrawler.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { WebClientResponseException.BadRequest.class})
    protected ResponseEntity<Object> handleBadRequestResponse(WebClientResponseException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getResponseBodyAsString(), ex.getHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}