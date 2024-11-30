package com.mitocode.enrollmentstudent.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

public record GenericResponseDTO(
        int status,
        String message,
        Object data
) {
    public GenericResponseDTO(int status, String message) {
        this(status, message, null);
    }
}
