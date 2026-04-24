package com.shh.service;

import com.shh.model.Person;
import com.shh.repository.JdbcRepository;
import com.shh.repository.Repository;
import java.util.Collection;


public class ServiceImpl implements Service {

    private final JdbcRepository<Person> repository;

    public ServiceImpl(JdbcRepository<Person> repository) {
        this.repository = repository;
    }

    @Override
    public Integer create(Person data) {
       return repository.create(data);
    }

    @Override
    public Person get(Integer id) {
        return repository.get(id).orElseThrow(
                ()-> new IllegalArgumentException("Message not found"));
    }

    @Override
    public Collection<Person> getAll() {
        return repository.getAll();
    }

    @Override
    public String update(Integer id, Person data) {
        repository.get(id).orElseThrow(
                ()-> new IllegalArgumentException("Message not found"));
        repository.update(id, data);
        return "Message with id " + id + " was updated";
    }

    @Override
    public String delete(Integer id) {
        boolean deleted = repository.delete(id);
        if (!deleted) {
                new IllegalArgumentException("Message not found");
        }
       return "Message with id " + id + " was deleted";
    }
}
