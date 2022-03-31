package com.example.demo.helper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListMapper<T,E> {
    @Autowired
    ModelMapper modelMapper;
    public List<?> mapList(List<T> l1, E convertTo){
        return l1.stream().map(i->modelMapper.map(i, convertTo.getClass())).collect(Collectors.toList());

    }
}
