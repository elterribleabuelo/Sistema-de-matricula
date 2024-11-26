package com.mitocode.enrollmentstudent.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

public record GenericResponseDTO<T>(
        int status,
        String message,
        List<T> data
) {
}
