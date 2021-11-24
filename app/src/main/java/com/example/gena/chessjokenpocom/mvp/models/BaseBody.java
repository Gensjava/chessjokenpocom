package com.example.gena.chessjokenpocom.mvp.models;


import com.example.gena.chessjokenpocom.helpers.GsonHelper;

public class BaseBody {
    @Override
    public String toString() {
        return GsonHelper.ObjectToGson(this);
    }


}
