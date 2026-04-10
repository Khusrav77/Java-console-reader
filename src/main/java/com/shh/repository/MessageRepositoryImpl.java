package com.shh.repository;
import com.shh.service.IdGenerator;
import com.shh.service.IdGeneratorImpl;

import java.util.*;


public final class MessageRepositoryImpl implements MessageRepository<Integer, String> {

    private final IdGenerator idGenerator;
    private final Map<Integer, String> storage;

    public MessageRepositoryImpl(Map<Integer, String> map) {
        this.storage = new HashMap<>(map);
        int maxId = storage.keySet()
                .stream()
                .max(Integer::compareTo)
                .orElse(0);
        this.idGenerator = new IdGeneratorImpl(maxId);
    }

    @Override
    public Integer create(String data) {
        var id = idGenerator.nextId();
        storage.put(id, data);
        return id;
    }

    @Override
    public Optional<String> get(Integer id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Collection<String> getAll () {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void update(Integer id, String data) {
       storage.put(id, data);
    }

    @Override
    public boolean delete(Integer id) {
        var isDeleted = storage.remove(id);
        return isDeleted !=null;
    }

    @Override
    public Map<Integer, String> getMap() {
        return new HashMap<>(storage);
    }
}
