package com.shh.repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public final class RepositoryImpl implements Repository<Integer, String> {

    private final Map<Integer, String> storageMap = new ConcurrentHashMap<>();

    @Override
    public void save(Integer id, String data) {
        storageMap.put(id, data);
    }

    @Override
    public Optional<String> get(Integer id) {
        return Optional.ofNullable(storageMap.get(id));
    }

    @Override
    public Collection<String> getAll () {
        return new ArrayList<>(storageMap.values());
    }

    @Override
    public boolean delete(Integer id) {
        return storageMap.remove(id) != null;
    }
}
