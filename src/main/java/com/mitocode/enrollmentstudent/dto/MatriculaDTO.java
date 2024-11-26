package com.mitocode.enrollmentstudent.dto;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MatriculaDTO {

    private Integer idMatricula;

    @NotNull
    @JsonIncludeProperties(value = {"idEstudiante"})
    private EstudianteDTO estudiante;

    @NotNull
    private LocalDateTime fechaMatricula;

    @NotNull
    @JsonManagedReference
    private List<DetalleMatriculaDTO> detalleMatricula;

    @NotNull
    private boolean estado;
}
