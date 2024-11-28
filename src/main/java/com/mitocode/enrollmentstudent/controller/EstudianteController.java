package com.mitocode.enrollmentstudent.controller;

import com.mitocode.enrollmentstudent.dto.EstudianteDTO;
import com.mitocode.enrollmentstudent.model.Estudiante;
import com.mitocode.enrollmentstudent.service.IEstudianteService;
import com.mitocode.enrollmentstudent.util.MapperUtil;
import com.mitocode.enrollmentstudent.validator.groups.OnCreate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estudiantes")

public class EstudianteController {

    private final IEstudianteService service;
    private final MapperUtil mapperUtil;

    @PostMapping
    public ResponseEntity<EstudianteDTO> save(@Validated(OnCreate.class) @Valid @RequestBody EstudianteDTO dto) throws Exception {
        Estudiante obj = service.save(mapperUtil.map(dto, Estudiante.class));
        return new ResponseEntity<>(mapperUtil.map(obj, EstudianteDTO.class),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> findAll() throws Exception {
        List<Estudiante> obj = service.findAll();
        return new ResponseEntity<>(mapperUtil.mapList(obj,EstudianteDTO.class), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> findById(@PathVariable int id) throws Exception {
        Estudiante obj = service.findById(id);
        return new ResponseEntity<>(mapperUtil.map(obj, EstudianteDTO.class), HttpStatus.OK);
    }

    @GetMapping("/ordenadoPorEdad")
    public ResponseEntity<List<EstudianteDTO>> orderByEdad() throws Exception {
        List<Estudiante> obj = service.orderByAge();
        return new ResponseEntity<>(mapperUtil.mapList(obj,EstudianteDTO.class), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> update(@Valid @RequestBody EstudianteDTO dto, @PathVariable int id) throws Exception {
        Estudiante obj = service.update(id, mapperUtil.map(dto, Estudiante.class));
        return new ResponseEntity<>(mapperUtil.map(obj, EstudianteDTO.class),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
