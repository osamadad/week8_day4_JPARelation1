package com.tuwaiq.week8_day4_schoolmanagement.Advice;

import com.tuwaiq.week8_day4_schoolmanagement.Api.ApiException;
import com.tuwaiq.week8_day4_schoolmanagement.Api.ApiResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLIntegrityConstraintViolationException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice{

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> ApiException(ApiException apiException){
        return ResponseEntity.status(400).body(new ApiResponse(apiException.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> MethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        return ResponseEntity.status(400).body(new ApiResponse(methodArgumentNotValidException.getFieldError().getDefaultMessage()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> ConstraintViolationException(ConstraintViolationException constraintViolationException) {
        return ResponseEntity.status(400).body(new ApiResponse(constraintViolationException.getMessage()));
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<?> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException sqlIntegrityConstraintViolationException){
        return ResponseEntity.status(400).body(new ApiResponse(sqlIntegrityConstraintViolationException.getMessage()));
    }

    @ExceptionHandler(InvalidDataAccessResourceUsageException.class )
    public ResponseEntity<?> InvalidDataAccessResourceUsageException(InvalidDataAccessResourceUsageException invalidDataAccessResourceUsageException){
        return ResponseEntity.status(400).body(new ApiResponse(invalidDataAccessResourceUsageException.getMessage()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> DataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException){
        return ResponseEntity.status(400).body(new ApiResponse(dataIntegrityViolationException.getMessage()));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException) {
        return ResponseEntity.status(400).body(new ApiResponse(httpRequestMethodNotSupportedException.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> HttpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException) {
        return ResponseEntity.status(400).body(new ApiResponse(httpMessageNotReadableException.getMessage()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException methodArgumentTypeMismatchException) {
        return ResponseEntity.status(400).body(new ApiResponse(methodArgumentTypeMismatchException.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralException(Exception exception) {
        return ResponseEntity.status(404).body(new ApiResponse("Page not found"));
    }
}
