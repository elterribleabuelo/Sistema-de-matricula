package com.mitocode.enrollmentstudent.service.impl;

import com.mitocode.enrollmentstudent.exception.ModelNotFoundException;
import com.mitocode.enrollmentstudent.repo.IGenericRepo;
import com.mitocode.enrollmentstudent.service.ICRUD;
import com.mitocode.enrollmentstudent.validator.groups.OnCreate;
import org.springframework.validation.annotation.Validated;

import java.lang.reflect.Method;
import java.util.List;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID> {

    protected abstract IGenericRepo<T,ID> getRepo();

    @Override
    public T save(@Validated(OnCreate.class) T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t) throws Exception {
        Class<?> clazz = t.getClass();
        String className = clazz.getSimpleName();
        String methodName = "setId" + className;
        Method setIdMethod = clazz.getMethod(methodName, id.getClass());
        setIdMethod.invoke(t, id);
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("ID NOT FOUND" +  id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().deleteById(id);
    }
}
