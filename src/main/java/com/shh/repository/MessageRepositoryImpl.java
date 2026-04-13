package com.shh.repository;
import com.shh.model.Person;
import com.shh.service.IdGenerator;
import com.shh.service.IdGeneratorImpl;

import java.util.*;


public final class MessageRepositoryImpl implements MessageRepository<Integer, Person> {

    private final IdGenerator idGenerator;
    private final Map<Integer, Person> storage;

    public MessageRepositoryImpl(Map<Integer, Person> map) {
        this.storage = new HashMap<>(map);
        int maxId = storage.keySet()
                .stream()
                .max(Integer::compareTo)
                .orElse(0);
        this.idGenerator = new IdGeneratorImpl(maxId);
    }

    @Override
    public Integer create(Person data) {
        var id = idGenerator.nextId();
        storage.put(id, data);
        return id;
    }

    @Override
    public Optional<Person> get(Integer id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Collection<Person> getAll () {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void update(Integer id, Person data) {
       storage.put(id, data);
    }

    @Override
    public boolean delete(Integer id) {
        var isDeleted = storage.remove(id);
        return isDeleted !=null;
    }

    @Override
    public Map<Integer, Person> getMap() {
        return new HashMap<>(storage);
    }
}
