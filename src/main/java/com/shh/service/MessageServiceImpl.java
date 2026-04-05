package com.shh.service;

import com.shh.repository.Repository;
import com.shh.util.IdGenerator;


import java.util.Collection;


public class MessageServiceImpl implements MessageService {

    private final   Repository<Integer,String> repository;

    public MessageServiceImpl(Repository<Integer, String> repository) {
        this.repository = repository;
    }

    @Override
    public Integer create(String data) {
       return repository.create(data);
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
