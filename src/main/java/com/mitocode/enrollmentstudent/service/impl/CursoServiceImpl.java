package com.mitocode.enrollmentstudent.service.impl;

import com.mitocode.enrollmentstudent.repo.ICursoRepo;
import com.mitocode.enrollmentstudent.repo.IGenericRepo;
import com.mitocode.enrollmentstudent.service.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class CursoServiceImpl extends CRUDImpl implements ICursoService {

    private final ICursoRepo repo;

    @Override
    protected IGenericRepo getRepo() {
        return repo;
    }
}
