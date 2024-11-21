package com.mitocode.enrollmentstudent.controller;

import com.mitocode.enrollmentstudent.dto.EstudianteDTO;
import com.mitocode.enrollmentstudent.model.Estudiante;
import com.mitocode.enrollmentstudent.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final IEstudianteService service;

    /*@PostMapping
    public ResponseEntity<Estudiante> save(@RequestBody EstudianteDTO dto) {

        return ResponseEntity.ok(estudiante);
    }*/
}
