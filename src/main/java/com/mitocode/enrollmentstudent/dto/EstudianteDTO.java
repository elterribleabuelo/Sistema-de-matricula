package com.mitocode.enrollmentstudent.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDTO {

    private Integer idEstudiante;

    @NotNull
    private String nombres;

    @NotNull
    private String apellidos;

    @NotNull
    @Pattern(regexp = "[0-9]+")
    private String dni;

    @NotNull
    @Min(value = 1)
    private Integer edad;
}
