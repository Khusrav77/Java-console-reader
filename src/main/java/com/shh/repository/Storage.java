package com.shh.repository;


import java.util.*;

public final class Storage<T> implements Repository<T> {

    private Integer id = 0;
    private final Map<Integer, T> storageMap = new HashMap<>();


    public Integer create(T data) {
        id++;
        storageMap.put(id, data);
        return id;
    }

    public T get(Integer id) {
        validate(id);
        return storageMap.get(id);
    }

    public List<T> getAll () {
        var list = storageMap.values();
        if (list.isEmpty()) {
            throw  new IllegalArgumentException("No data found");
        }
        return new ArrayList<>(list);
    }

    public T update(Integer id, T newData) {
        validate(id);
        storageMap.put(id, newData);
        return storageMap.get(id);
    }

    public T delete(Integer id) {
        validate(id);
        return storageMap.remove(id);
    }


    private void validate(Integer id) {
        if (!storageMap.containsKey(id)) {
            throw new IllegalArgumentException("Data not found for id " + id);
        }
    }




}
