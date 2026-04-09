package com.shh.repository;
import com.shh.util.IdGenerator;
import java.util.*;


public final class RepositoryImpl implements Repository<Integer, String> {

    private final IdGenerator idGenerator;
    private  Map<Integer, String> storageMap;

    public RepositoryImpl(IdGenerator idGenerator, Map<Integer, String> map) {
        this.storageMap = new HashMap<>(map);
        this.idGenerator = idGenerator;
    }

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
    public void update(Integer id, String data) {
       storageMap.put(id, data);
    }

    @Override
    public boolean delete(Integer id) {
        var isDeleted = storageMap.remove(id);
        return isDeleted !=null;
    }

    @Override
    public Map<Integer, String> getMap() {
        return new HashMap<>(storageMap);
    }
}
