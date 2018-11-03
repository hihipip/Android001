package com.ani.mytest.loader.dao;

import android.content.Context;

import com.ani.mytest.loader.UrlTool;
import com.ani.mytest.loader.pojo.Login;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * 處理登入耗時的工作
 */
public class LoginDao<T> extends BaseDao<T>{

    public LoginDao(Context context) {
        super(context);
    }

    private String param="act=login1";

    @Override
    public T getDataFromUrl(){
        try {
            String data=UrlTool.getDataFromUrl("https://box.innokit.tw/test.jsp?"+param);
            this.result = parseJson(data,new TypeToken<Login>(){}.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
