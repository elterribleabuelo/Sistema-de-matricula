package com.mitocode.enrollmentstudent.controller;

import com.mitocode.enrollmentstudent.dto.MatriculaDTO;
import com.mitocode.enrollmentstudent.model.Matricula;
import com.mitocode.enrollmentstudent.service.IMatriculaService;
import com.mitocode.enrollmentstudent.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/matricula")

public class MatriculaController {

    private final IMatriculaService service;
    private final MapperUtil mapperUtil;

    @PostMapping
    public ResponseEntity<MatriculaDTO> save(@RequestBody MatriculaDTO dto) throws Exception {
        Matricula obj = service.save(mapperUtil.map(dto, Matricula.class));
        return new ResponseEntity<>(mapperUtil.map(obj, MatriculaDTO.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> findAll() throws Exception {
        List<Matricula> obj = service.findAll();
        return new ResponseEntity<>(mapperUtil.mapList(obj,MatriculaDTO.class), HttpStatus.OK);
    }

    @GetMapping("studentsByCourse")
    public ResponseEntity<Map<String, List<String>>> getStudentsByCourse() throws Exception {
        Map<String, List<String>> obj =  service.getStudentsByCourse();
        return ResponseEntity.ok(obj);
    }

}
