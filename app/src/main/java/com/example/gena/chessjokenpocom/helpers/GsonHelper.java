package com.example.gena.chessjokenpocom.helpers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public final class GsonHelper {

    public static <T> T fromGsonToObject(Type aClass, String body) {
        Gson gson = new GsonBuilder().create();
        try {
            return gson.fromJson(body, aClass);
        } catch (Exception e) {
            Class<?> clazz = null;
            Object date = null;
            try {
                clazz = Class.forName(aClass.toString());
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            try {
                date = clazz.newInstance();
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }

            return (T) date;
        }
    }

    public static String ObjectToGson(Object body) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(body);
    }
}
