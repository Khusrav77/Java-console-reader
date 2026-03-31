package com.shh.repository;

import java.util.List;

public interface Repository<T, ID> {

    ID create(ID id, T data);
    T get(ID id);
    List<T> getAll();
    T update(ID id, T newData);
    T delete(ID id);

}
