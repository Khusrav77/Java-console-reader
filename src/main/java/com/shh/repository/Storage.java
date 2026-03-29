package com.shh.repository;

import java.util.HashMap;
import java.util.Map;

public class Storage {

    Integer id = 0;
    Map<Integer, String> storageMap = new HashMap<>();

    public Integer create(String input) {
        id++;
        storageMap.put(id, input);
        return id;
    }

    public String get(Integer id) {
        return storageMap.get(id);
    }



}
