package com.mitocode.enrollmentstudent.controller;

import com.mitocode.enrollmentstudent.dto.EstudianteDTO;
import com.mitocode.enrollmentstudent.dto.GenericResponseDTO;
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
    public ResponseEntity<GenericResponseDTO> save(@Validated(OnCreate.class) @Valid @RequestBody EstudianteDTO dto) throws Exception {
        Estudiante obj = service.save(mapperUtil.map(dto, Estudiante.class));
        EstudianteDTO estudianteDTO = mapperUtil.map(obj, EstudianteDTO.class);
        return new ResponseEntity<>(new GenericResponseDTO(201,"success",estudianteDTO),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<GenericResponseDTO> findAll() throws Exception {
        List<Estudiante> obj = service.findAll();
        List<EstudianteDTO> dto =  mapperUtil.mapList(obj,EstudianteDTO.class);
        return ResponseEntity.ok(new GenericResponseDTO(200,"success",dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponseDTO> findById(@PathVariable int id) throws Exception {
        Estudiante obj = service.findById(id);
        EstudianteDTO dto =  mapperUtil.map(obj, EstudianteDTO.class);
        return ResponseEntity.ok(new GenericResponseDTO(200,"success",dto));
    }

    @GetMapping("/ordenadoPorEdad")
    public ResponseEntity<GenericResponseDTO> orderByEdad() throws Exception {
        List<Estudiante> obj = service.orderByAge();
        List<EstudianteDTO> dto = mapperUtil.mapList(obj,EstudianteDTO.class);
        return ResponseEntity.ok(new GenericResponseDTO(200,"success",dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponseDTO> update(@Valid @RequestBody EstudianteDTO dto, @PathVariable int id) throws Exception {
        Estudiante obj = service.update(id, mapperUtil.map(dto, Estudiante.class));
        EstudianteDTO estudianteDTO = mapperUtil.map(obj, EstudianteDTO.class);
        return ResponseEntity.ok(new GenericResponseDTO(200,"success",estudianteDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponseDTO> delete(@PathVariable int id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
