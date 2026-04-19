package com.shh.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shh.model.Person;

public class MapperImpl implements Mapper {

    private final ObjectMapper  mapper;

    public MapperImpl(ObjectMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public Person jsonToObject(String json) throws JsonProcessingException {
        return mapper.readValue(json, Person.class);
    }

    @Override
    public String objectToJson(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }
}
