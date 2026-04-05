package com.shh.repository;

import java.util.Collection;
import java.util.Optional;

public interface Repository<ID, T> {

    Integer create(T data);
    Optional<T> get(ID id);
    Collection<T> getAll();
    boolean update(ID id, T data);
    boolean delete(ID id);

}
