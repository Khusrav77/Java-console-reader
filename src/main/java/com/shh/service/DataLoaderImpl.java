package com.shh.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shh.model.Person;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DataLoaderImpl implements DataLoader{

    private static final String FILE_NAME = "person.json";
    private static final String FILE_PATH = System.getProperty("user.home") + File.separator + FILE_NAME;
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Map<Integer, Person> load() {

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new HashMap<>();
        }

        try {
           return mapper.readValue(
                   file, new TypeReference<Map<Integer, Person>>(){});

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    @Override
    public void save(Map<Integer, Person> persons) {

        try {
            mapper.writeValue(new File(FILE_PATH), persons);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
