package com.shh.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface Repository<ID, T> {

    void create(ID id, T data);
    Optional<T> get(ID id);
    Collection<T> getAll();
    void update(ID id, T newData);
    void delete(ID id);

}
