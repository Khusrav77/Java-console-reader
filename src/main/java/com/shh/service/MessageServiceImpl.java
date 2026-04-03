package com.shh.service;

import com.shh.repository.Repository;
import com.shh.util.IdGenerator;


import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageServiceImpl implements MessageService {

    private final   Repository<Integer,String> repository;
    private final IdGenerator idGenerator;

    public MessageServiceImpl(Repository<Integer, String> repository,
                              IdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    @Override
    public Integer create(String data) {
        Integer id = idGenerator.nextId();
        repository.save(id, data);
        return id;
    }

    @Override
    public String get(Integer id) {
        return repository.get(id).orElseThrow(
                ()-> new IllegalArgumentException("Message not found"));
    }

    @Override
    public Collection<String> getAll() {
        return repository.getAll();
    }

    @Override
    public String update(Integer id, String data) {
        repository.get(id).orElseThrow(
                ()-> new IllegalArgumentException("Message not found"));
        repository.save(id, data);
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
