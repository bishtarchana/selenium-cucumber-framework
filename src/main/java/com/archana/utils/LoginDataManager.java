package com.archana.utils;

import org.json.JSONObject;

public class LoginDataManager{
    static JSONObject data = JsonUtil.getLoginData();
    public static String getValidUsername(){
        return data.getJSONObject("validUser").getString("username");
    }
    public static String getValidPassword(){
        return data.getJSONObject("validUser").getString("password");
    }
    public static String getInvalidUsername(){
        return data.getJSONObject("invalidUser").getString("username");
    }
    public static String getInvalidPassword(){
        return data.getJSONObject("invalidUser").getString("password");
    }
    public static String getExpectedSuccessTitle(){
        return data.getJSONObject("messages").getString("loginSuccessTitle");
    }
    public static String getExpectedErrorMessage(){
        return data.getJSONObject("messages").getString("loginError");
    }
}

