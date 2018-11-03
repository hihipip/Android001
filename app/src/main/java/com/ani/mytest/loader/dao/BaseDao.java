package com.ani.mytest.loader.dao;

import android.content.Context;

import com.google.gson.Gson;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * Created by ghost on 2018/11/3.
 */

public abstract class BaseDao<T> implements Serializable {
    protected Context mContext;
    protected T result;
    public BaseDao(Context context) {
        mContext = context;
    }
    abstract public T getDataFromUrl();


    protected <T> T parseJson(String result,Type obj){
        Gson gson= new Gson();
        return gson.fromJson((String)result,obj);

    }

}
