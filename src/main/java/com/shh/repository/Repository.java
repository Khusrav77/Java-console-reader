package com.shh.repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface Repository<ID, T> {

    Integer create(T data);
    Optional<T> get(ID id);
    Collection<T> getAll();
    void update(ID id, T data);
    boolean delete(ID id);
    Map<ID, T> getMap();

}
