package com.shh.repository;

import java.util.Collection;
import java.util.Optional;

public interface Repository<ID, T> {

    void save(ID id, T data);
    Optional<T> get(ID id);
    Collection<T> getAll();
    boolean delete(ID id);

}
