package com.shh.repository;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public final class Storage<T, ID> implements Repository<T, ID> {

    private final Map<ID, T> storageMap = new ConcurrentHashMap<>();



    @Override
    public ID create(ID id, T data) {

        if(storageMap.containsKey(id)){
            throw new IllegalArgumentException("ID already exists: " + id);
        }
        storageMap.put(id, data);
        return id;
    }

    @Override
    public T get(ID id) {
        validate(id);
        return storageMap.get(id);
    }

    @Override
    public List<T> getAll () {
        return new ArrayList<>(storageMap.values());
    }

    @Override
    public T update(ID id, T newData) {
        validate(id);
        storageMap.put(id, newData);
        return newData;
    }

    @Override
    public T delete(ID id) {
        validate(id);
        return storageMap.remove(id);
    }


    private T validate(ID id) {
        T value = storageMap.get(id);
        if (value == null) {
            throw new IllegalArgumentException("Data not found for id " + id);
        }
        return value;
    }




}
