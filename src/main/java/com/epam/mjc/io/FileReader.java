package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        Map<String, String> map = fileToMap(file);
        profile.setAge(Integer.parseInt(map.get("Age")));
        profile.setName(map.get("Name"));
        profile.setEmail(map.get("Email"));
        profile.setPhone(Long.parseLong(map.get("Phone")));
        return profile;
    }

    private static Map<String, String> fileToMap(File file) {
        Map<String, String> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] split = line.split(": ");
                map.put(split[0], split[1]);
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}
