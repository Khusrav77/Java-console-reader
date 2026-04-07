package com.shh.service;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataLoaderImpl implements DataLoader{

    private static String FILE_NAME = "data.txt";

    @Override
    public Map<Integer, String> load() {
        Map<Integer, String> data = new ConcurrentHashMap<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return data;
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine())!= null){

                String [] parts = line.split(":", 2);
                if (parts.length != 2) continue;

                var id = Integer.parseInt(parts[0]);
                var value = parts[1];

                data.put(id, value);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    @Override
    public void save(Map<Integer, String> messages) {

        try(FileWriter writer = new FileWriter(FILE_NAME)) {
            for (Map.Entry<Integer,String> entry : messages.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
