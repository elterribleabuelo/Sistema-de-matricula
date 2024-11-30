package com.mitocode.enrollmentstudent.controller;

import com.mitocode.enrollmentstudent.dto.GenericResponseDTO;
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
    public ResponseEntity<GenericResponseDTO> save(@RequestBody MatriculaDTO dto) throws Exception {
        Matricula obj = service.save(mapperUtil.map(dto, Matricula.class));
        MatriculaDTO matriculaDTO = mapperUtil.map(obj, MatriculaDTO.class);
        return new ResponseEntity<>(new GenericResponseDTO(201,"success",matriculaDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<GenericResponseDTO> findAll() throws Exception {
        List<Matricula> obj = service.findAll();
        List<MatriculaDTO> dto = mapperUtil.mapList(obj,MatriculaDTO.class);
        return ResponseEntity.ok(new GenericResponseDTO(200,"success",dto));
    }

    @GetMapping("estudiantesPorCurso")
    public ResponseEntity<GenericResponseDTO> getStudentsByCourse() throws Exception {
        Map<String, List<String>> obj =  service.getStudentsByCourse();
        return ResponseEntity.ok(new GenericResponseDTO(200,"success",obj));
    }

}
