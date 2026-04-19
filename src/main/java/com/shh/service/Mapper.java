package com.shh.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shh.model.Person;

public interface Mapper {
    Person jsonToObject(String json) throws JsonProcessingException;
    String objectToJson(Object person) throws JsonProcessingException;
}
