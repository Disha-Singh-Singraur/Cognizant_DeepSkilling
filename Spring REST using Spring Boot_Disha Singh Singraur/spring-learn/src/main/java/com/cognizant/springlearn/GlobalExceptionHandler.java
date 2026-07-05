package com.cognizant.springlearn;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Handout 4: GlobalExceptionHandler class with logs and overrides
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Handout 4: Handle validation errors (e.g. invalid country code or name length)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        LOGGER.info("Start handleMethodArgumentNotValid");

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        // Get all validation errors
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);
        LOGGER.info("End handleMethodArgumentNotValid");

        return new ResponseEntity<>(body, headers, status);
    }

    // Handout 4: Handle formatting errors (e.g. passing text into a numeric field)
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        LOGGER.info("Start handleHttpMessageNotReadable");

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());
        body.put("error", "Bad Request");

        if (ex.getCause() instanceof InvalidFormatException) {
            final Throwable cause = ex.getCause();
            for (InvalidFormatException.Reference reference : ((InvalidFormatException) cause).getPath()) {
                body.put("message", "Incorrect format for field '" + reference.getFieldName() + "'");
            }
        } else {
            body.put("message", ex.getMostSpecificCause().getMessage());
        }

        LOGGER.info("End handleHttpMessageNotReadable");

        return new ResponseEntity<>(body, headers, status);
    }
}
