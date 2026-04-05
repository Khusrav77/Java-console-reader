package com.shh.repository;
import com.shh.util.IdGenerator;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public final class RepositoryImpl implements Repository<Integer, String> {

    private final IdGenerator idGenerator;

    public RepositoryImpl(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    private final Map<Integer, String> storageMap = new ConcurrentHashMap<>();

    @Override
    public Integer create(String data) {
        var id = idGenerator.nextId();
        storageMap.put(id, data);
        return id;
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
    public boolean update(Integer id, String data) {
       storageMap.put(id, data);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        return storageMap.remove(id) != null;
    }
}
