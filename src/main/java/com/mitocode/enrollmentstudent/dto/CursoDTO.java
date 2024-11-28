package com.mitocode.enrollmentstudent.dto;

import com.mitocode.enrollmentstudent.validator.UniqueNameCourse;
import com.mitocode.enrollmentstudent.validator.groups.OnCreate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CursoDTO {

    private Integer idCurso;

    @NotNull
    @UniqueNameCourse(groups = OnCreate.class)
    private String nombre;

    @NotNull
    @Size(min = 3, max = 20)
    private String siglas;

    @NotNull
    private boolean estado;
}
