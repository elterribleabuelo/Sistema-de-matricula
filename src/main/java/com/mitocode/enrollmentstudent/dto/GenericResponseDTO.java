package com.mitocode.enrollmentstudent.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

public record GenericResponseDTO(
        int status,
        String message,
        Object data
) {
}
