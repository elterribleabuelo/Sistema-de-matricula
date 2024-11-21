package com.mitocode.enrollmentstudent.util;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@RequiredArgsConstructor
@Configuration


public class MapperUtil {

    private final ModelMapper modelMapper;

    private final ApplicationContext applicationContext;

    public <S,T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(e->modelMapper.map(e,targetClass))
                .toList();
    }

    public <S,T> T map(S source, Class<T> targetClass) {
        return modelMapper.map(source,targetClass);
    }
}
