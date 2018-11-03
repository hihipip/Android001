package com.ani.mytest.loader.dao;

import android.content.Context;

import com.ani.mytest.loader.UrlTool;
import com.ani.mytest.loader.pojo.Member;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * 處理登入耗時的工作
 */
public class MemberDao<T> extends BaseDao<T>{

    public MemberDao(Context context) {
        super(context);
    }

    private String param="act=member";

    @Override
    public T getDataFromUrl(){
        try {
            String data=UrlTool.getDataFromUrl("https://box.innokit.tw/test.jsp?"+param);
            this.result = parseJson(data,new TypeToken<Member>(){}.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }



}
