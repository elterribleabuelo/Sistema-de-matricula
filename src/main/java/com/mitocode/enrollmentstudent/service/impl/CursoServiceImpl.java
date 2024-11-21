package com.mitocode.enrollmentstudent.service.impl;

import com.mitocode.enrollmentstudent.model.Curso;
import com.mitocode.enrollmentstudent.repo.ICursoRepo;
import com.mitocode.enrollmentstudent.repo.IGenericRepo;
import com.mitocode.enrollmentstudent.service.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class CursoServiceImpl extends CRUDImpl<Curso,Integer> implements ICursoService {

    private final ICursoRepo repo;

    @Override
    protected IGenericRepo getRepo() {
        return repo;
    }
}
