package com.archana.utils;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtil {
    private static JSONObject readJson(String path) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            return new JSONObject(content);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject getConfig() {
        return readJson("src/test/resources/testdata/config.json");
    }

    public static JSONObject getLoginData() {
        return readJson("src/test/resources/testdata/loginData.json");
    }
}