package com.shh.service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DataLoaderImpl implements DataLoader{

    private static String FILE_NAME = "data.txt";
    private static String FILE_PATH = System.getProperty("user.home") + File.separator + FILE_NAME;

    @Override
    public Map<Integer, String> load() {
        Map<Integer, String> map = new HashMap<>();

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return map;
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            while ((line = reader.readLine())!= null){
                String [] parts = line.split(":", 2);
                if (parts.length != 2) continue;

                var id = Integer.parseInt(parts[0]);
                var value = parts[1];
                map.put(id, value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public void save(Map<Integer, String> map) {

        try(FileWriter writer = new FileWriter(FILE_PATH)) {
            for (Map.Entry<Integer,String> entry : map.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
