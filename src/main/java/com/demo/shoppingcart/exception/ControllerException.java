package com.demo.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<ApiError> handleException(UserNotFoundException ex) {
        ApiError message = getApiError(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ProductNotFoundException.class})
    public ResponseEntity<ApiError> handleException(ProductNotFoundException ex) {
        ApiError error = getApiError(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {CartNotFoundException.class})
    public ResponseEntity<ApiError> handleException(CartNotFoundException ex) {
        ApiError error = getApiError(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {OrderNotFoundException.class})
    public ResponseEntity<ApiError> handleException(OrderNotFoundException ex) {
        ApiError error = getApiError(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {CartEmptyException.class})
    public ResponseEntity<ApiError> handleException(CartEmptyException ex) {
        ApiError error = getApiError(ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {InvalidRequestException.class})
    public ResponseEntity<ApiError> handleException(InvalidRequestException ex) {
        ApiError error = getApiError(ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    private ApiError getApiError(String message, HttpStatus httpStatus) {
        return new ApiError(httpStatus, message);
    }
}
