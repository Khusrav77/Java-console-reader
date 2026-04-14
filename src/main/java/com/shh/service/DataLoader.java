package com.shh.service;

import com.shh.model.Person;

import java.util.Map;

public interface DataLoader {

    Map<Integer, Person> load();
    void save(Map<Integer, Person> persons);
}
