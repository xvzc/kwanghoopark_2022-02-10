package com.example.oembed.global.error;

import com.example.oembed.global.dto.ErrorResponse;
import com.example.oembed.global.error.exceptions.InvalidInputException;
import com.example.oembed.global.error.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ResourceNotFoundException.class)
    protected ErrorResponse handleResourceNotFoundException(ResourceNotFoundException e) {
        log.error("handleMethodArgumentNotValidException", e);
        return ErrorResponse.of(BasicError.of(e.errorCode));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidInputException.class)
    protected ErrorResponse handleAlreadyExistsException(InvalidInputException e) {
        log.error("handleInvalidInputException", e);
        return ErrorResponse.of(BasicError.of(e.errorCode));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("handleMethodArgumentNotValidException", e);
        return ErrorResponse.of(BasicError.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult()));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HttpClientErrorException.class)
    protected ErrorResponse handleHttpClientErrorException(HttpClientErrorException e) {
        log.error("handleMethodArgumentNotValidException", e);
        return ErrorResponse.of(BasicError.of(ErrorCode.PREVIEW_NOT_FOUND));
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    protected ErrorResponse handleException(Exception e) {
        log.error("unhandledException", e);
        return ErrorResponse.of(BasicError.of(ErrorCode.INTERNAL_SERVER_ERROR));
    }
}