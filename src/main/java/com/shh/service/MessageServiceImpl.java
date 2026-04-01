package com.shh.service;

import com.shh.repository.Repository;

import java.util.Collection;
import java.util.List;

public class MessageServiceImpl implements MessageService {

    private  Repository repository;

    @Override
    public Integer create() {
        return 0;
    }

    @Override
    public String get() {
        return "";
    }

    @Override
    public Collection<String> getAll() {
        return List.of();
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
