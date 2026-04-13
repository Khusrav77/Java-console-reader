package com.shh.service;

import com.shh.model.Person;

import java.util.Collection;

public interface MessageService {

    Integer create(Person data);
    Person get(Integer id);
    Collection<Person> getAll();
    String update(Integer id, Person data);
    String delete(Integer id);
}
