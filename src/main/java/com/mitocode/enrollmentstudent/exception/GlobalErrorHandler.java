package com.mitocode.enrollmentstudent.exception;

import com.mitocode.enrollmentstudent.dto.GenericResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice

public class GlobalErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponseDTO<CustomErrorResponse>> handleDefaultException(Exception ex, WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(new GenericResponseDTO<>(500,"internal-server-error", List.of(errorResponse)), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<GenericResponseDTO<CustomErrorResponse>> handleModelNotFoundException(ModelNotFoundException ex , WebRequest request){
        CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(new GenericResponseDTO<>(404,"not-found", List.of(errorResponse)), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponseDTO<CustomErrorResponse>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex , WebRequest request){
        String message = ex.getBindingResult().getFieldErrors().stream().map(error->error.getField() + ": " + error.getDefaultMessage()).collect(Collectors.joining(","));
        CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(),message, request.getDescription(false));
        return new ResponseEntity<>(new GenericResponseDTO<>(400,"bad-request", List.of(errorResponse)),HttpStatus.BAD_REQUEST);
    }
}
