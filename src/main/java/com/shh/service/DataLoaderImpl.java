package com.shh.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shh.model.Person;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DataLoaderImpl implements DataLoader{

    private static final String FILE_NAME = "person.txt";
    private static final String FILE_PATH = System.getProperty("user.home") + File.separator + FILE_NAME;
    private final ObjectMapper mapper;

    public DataLoaderImpl(ObjectMapper mapper){this.mapper = mapper;}

    @Override public Map<Integer, Person> load() {
        Map<Integer, Person> map = new HashMap<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) { return map; }

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine())!= null) {
                String [] parts = line.split(":", 2);
                if (parts.length != 2) continue;
                var id = Integer.parseInt(parts[0]);
                Person person = mapper.readValue(parts[1], Person.class);
                map.put(id, person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public void save(Map<Integer, Person> map) {
        try(FileWriter writer = new FileWriter(FILE_PATH)) {
            for (Map.Entry<Integer,Person> entry : map.entrySet()) {
                String json = mapper.writeValueAsString(entry.getValue());
                writer.write(entry.getKey() + ":" + json + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
