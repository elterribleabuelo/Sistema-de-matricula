package com.mitocode.enrollmentstudent.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CursoDTO {

    @NotNull
    private Integer idCurso;

    @NotNull
    private String nombre;

    @NotNull
    @Size(min = 3, max = 20)
    private String siglas;

    @NotNull
    private boolean estado;
}
