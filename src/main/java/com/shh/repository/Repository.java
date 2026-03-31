package com.shh.repository;

import java.util.List;

public interface Repository<T> {

    T create(T data);
    T get(Integer id);
    List<T> getAll();
    T update(Integer id, T newData);
    T delete(Integer id);

}
