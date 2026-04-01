package com.shh.service;

import java.util.Collection;

public interface MessageService {

    Integer create();
    String get();
    Collection<String> getAll();
    void update();
    void delete();
}
