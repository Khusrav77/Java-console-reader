package com.shh.repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public final class RepositoryImpl implements Repository<Integer, String> {

    private final Map<Integer, String> storageMap = new ConcurrentHashMap<>();

    @Override
    public Integer create(Integer id, String data) {

        if(storageMap.containsKey(id)){
            throw new IllegalArgumentException("ID already exists: " + id);
        }
        storageMap.put(id, data);
        return id;
    }

    @Override
    public Integer get(Integer id) {
        validate(id);
        return storageMap.get(id);
    }

    @Override
    public List<String> getAll () {
        return new ArrayList<>(storageMap.values());
    }

    @Override
    public String update(Integer id, String newData) {
        validate(id);
        storageMap.put(id, newData);
        return newData;
    }

    @Override
    public Integer delete(Integer id) {
        validate(id);
        return storageMap.remove(id);
    }

    private Integer validate(Integer id) {
        Integer value = storageMap.get(id);
        if (value == null) {
            throw new IllegalArgumentException("Data not found for id " + id);
        }
        return value;
    }

}
