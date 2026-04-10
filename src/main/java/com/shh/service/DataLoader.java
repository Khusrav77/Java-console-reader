package com.shh.service;

import java.util.Map;

public interface DataLoader {

    Map<Integer, String> load();
    void save(Map<Integer, String> messages);

}
