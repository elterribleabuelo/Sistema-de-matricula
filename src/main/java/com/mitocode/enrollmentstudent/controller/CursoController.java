package com.mitocode.enrollmentstudent.controller;

import com.mitocode.enrollmentstudent.dto.CursoDTO;
import com.mitocode.enrollmentstudent.dto.GenericResponseDTO;
import com.mitocode.enrollmentstudent.model.Curso;
import com.mitocode.enrollmentstudent.service.ICursoService;
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
@RequestMapping("/cursos")
public class CursoController {

    private final ICursoService service;
    private final MapperUtil mapperUtil;

    @PostMapping
    public ResponseEntity<GenericResponseDTO> save(@Validated(OnCreate.class) @Valid @RequestBody CursoDTO dto) throws Exception {
        Curso obj = service.save(mapperUtil.map(dto, Curso.class));
        CursoDTO cursoDTO = mapperUtil.map(obj, CursoDTO.class);
        return new ResponseEntity<>(new GenericResponseDTO(201,"success",cursoDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<GenericResponseDTO> findAll() throws Exception {
        List<Curso> obj = service.findAll();
        List<CursoDTO> dto = mapperUtil.mapList(obj,CursoDTO.class);
        return ResponseEntity.ok(new GenericResponseDTO(200,"success",dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponseDTO> findById(@PathVariable int id) throws Exception {
        Curso obj = service.findById(id);
        CursoDTO cursoDTO = mapperUtil.map(obj, CursoDTO.class);
        return ResponseEntity.ok(new GenericResponseDTO(200,"success",cursoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponseDTO> update(@Valid @RequestBody CursoDTO dto, @PathVariable int id) throws Exception {
        Curso obj = service.update(id, mapperUtil.map(dto, Curso.class));
        CursoDTO cursoDTO = mapperUtil.map(obj, CursoDTO.class);
        return ResponseEntity.ok(new GenericResponseDTO(200,"success",cursoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponseDTO> delete(@PathVariable int id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
