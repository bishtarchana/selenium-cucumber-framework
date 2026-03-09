package com.archana.utils;

import org.json.JSONObject;

public class ConfigManager {
    static JSONObject config = JsonUtil.getConfig();
    public static String getUrl(){
        return config.getString("url");
    }
    public static String getBrowser(){
        return config.getString("browser");
    }
}
