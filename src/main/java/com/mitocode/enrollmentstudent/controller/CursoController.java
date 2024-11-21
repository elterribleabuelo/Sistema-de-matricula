package com.mitocode.enrollmentstudent.controller;

import com.mitocode.enrollmentstudent.dto.CursoDTO;
import com.mitocode.enrollmentstudent.dto.EstudianteDTO;
import com.mitocode.enrollmentstudent.model.Curso;
import com.mitocode.enrollmentstudent.model.Estudiante;
import com.mitocode.enrollmentstudent.service.ICursoService;
import com.mitocode.enrollmentstudent.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cursos")
public class CursoController {

    private final ICursoService service;
    private final MapperUtil mapperUtil;

    @PostMapping
    public ResponseEntity<CursoDTO> save(@Valid @RequestBody CursoDTO dto) throws Exception {
        Curso obj = service.save(mapperUtil.map(dto, Curso.class));
        return new ResponseEntity<>(mapperUtil.map(obj, CursoDTO.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> findAll() throws Exception {
        List<Curso> obj = service.findAll();
        return new ResponseEntity<>(mapperUtil.mapList(obj,CursoDTO.class), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> findById(@PathVariable int id) throws Exception {
        Curso obj = service.findById(id);
        return new ResponseEntity<>(mapperUtil.map(obj, CursoDTO.class), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> update(@Valid @RequestBody CursoDTO dto, @PathVariable int id) throws Exception {
        Curso obj = service.update(id, mapperUtil.map(dto, Curso.class));
        return new ResponseEntity<>(mapperUtil.map(obj, CursoDTO.class),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
