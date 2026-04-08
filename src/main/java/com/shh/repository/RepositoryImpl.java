package com.shh.repository;
import com.shh.service.DataLoader;
import com.shh.util.IdGenerator;
import com.shh.util.IdGeneratorImpl;

import java.util.*;


public final class RepositoryImpl implements Repository<Integer, String> {

    private final IdGenerator idGenerator;
    private final DataLoader dataLoader;
    private  Map<Integer, String> storageMap;

    public RepositoryImpl(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
        this.storageMap = dataLoader.load();

        int maxId = storageMap.keySet()
                .stream()
                .max(Integer::compareTo)
                .orElse(0);

        this.idGenerator = new IdGeneratorImpl(maxId);
    }

    @Override
    public Integer create(String data) {
        var id = idGenerator.nextId();
        storageMap.put(id, data);
        dataLoader.save(storageMap);
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
    public void update(Integer id, String data) {
       storageMap.put(id, data);
        dataLoader.save(storageMap);
    }

    @Override
    public boolean delete(Integer id) {
        var isDeleted = storageMap.remove(id);
        dataLoader.save(storageMap);
        return isDeleted !=null;
    }

    @Override
    public Map<Integer, String> getMap() {
        return new HashMap<>(storageMap); // вернуть копию
    }
}
