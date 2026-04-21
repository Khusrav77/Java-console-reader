package com.shh.repository;

import java.util.Collection;
import java.util.Optional;

public interface JdbcRepository<T> {
    Integer create(T data);
    Optional<T> get(Integer id);
    Collection<T> getAll();
    void update(Integer id, T data);
    boolean delete(Integer id);
}
