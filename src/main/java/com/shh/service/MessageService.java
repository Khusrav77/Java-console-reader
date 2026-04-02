package com.shh.service;

import java.util.Collection;

public interface MessageService {

    Integer create(String data);
    String get(Integer id);
    Collection<String> getAll();
    String update(Integer id, String data);
    String delete(Integer id);
}
