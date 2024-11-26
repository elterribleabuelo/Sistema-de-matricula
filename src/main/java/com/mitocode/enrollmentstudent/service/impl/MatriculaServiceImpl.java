package com.mitocode.enrollmentstudent.service.impl;
import com.mitocode.enrollmentstudent.dto.AuxDTO;
import com.mitocode.enrollmentstudent.model.DetalleMatricula;
import com.mitocode.enrollmentstudent.model.Matricula;
import com.mitocode.enrollmentstudent.repo.IGenericRepo;
import com.mitocode.enrollmentstudent.repo.IMatriculaRepo;
import com.mitocode.enrollmentstudent.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@RequiredArgsConstructor

@Service
public class MatriculaServiceImpl extends CRUDImpl<Matricula,Integer> implements IMatriculaService {

    private final IMatriculaRepo matriculaRepo;

    @Override
    protected IGenericRepo getRepo() {
        return matriculaRepo;
    }

    @Override
    public Map<String, List<String>> getStudentsByCourse() {

        Stream<Matricula> matriculaStream = matriculaRepo.findAll().stream();

        Stream<List<DetalleMatricula>> lsStream  = matriculaStream.map(Matricula::getDetalleMatricula);

        Stream<DetalleMatricula> streamDetalleMatricula = lsStream.flatMap(Collection::stream);

        Stream<AuxDTO> streamAuxDTO = streamDetalleMatricula.map(e-> new AuxDTO(e.getCurso().getNombre(),e.getMatricula().getEstudiante().getNombres()));

        List<AuxDTO> auxDTOList = streamAuxDTO.toList();

        Map<String, List<AuxDTO>> studentsByCourse =auxDTOList.stream()
                .collect(groupingBy(AuxDTO::getNombreCurso));

        return studentsByCourse.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry->entry.getValue().stream()
                                .map(AuxDTO::getNombresEstudiante)
                                .toList()
                ));
    }
}
