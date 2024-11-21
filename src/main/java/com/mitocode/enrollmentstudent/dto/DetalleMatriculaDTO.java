package com.mitocode.enrollmentstudent.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.validation.constraints.NotNull;

public class DetalleMatriculaDTO {

    @JsonBackReference
    private MatriculaDTO matricula;

    @NotNull
    @JsonIncludeProperties(value = {"idCurso"})
    private CursoDTO curso;

    @NotNull
    private String aula;
}
