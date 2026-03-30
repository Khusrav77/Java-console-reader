package com.shh.repository;

import com.shh.model.OutputMessage;

import java.util.*;

public class Storage {

    private Integer id = 0;
    private final Map<Integer, String> storageMap = new HashMap<>();


    public Integer create(String input) {
        id++;
        storageMap.put(id, input);
        return id;
    }

    public String get(Integer id) {
        validate(id);
        return storageMap.get(id);
    }

    public OutputMessage getAll () {
        var list = storageMap.values();
        if (list.isEmpty()) {
            return new OutputMessage("No data found");
        }
        return new OutputMessage(list.toString());
    }

    public String update(Integer id, String newData) {
        validate(id);
        storageMap.put(id, newData);
        return storageMap.get(id);
    }

    public String delete(Integer id) {
        validate(id);
        return storageMap.remove(id);
    }


    private void validate(Integer id) {
        if (!storageMap.containsKey(id)) {
            throw new IllegalArgumentException("Data not found for id " + id);
        }
    }




}
