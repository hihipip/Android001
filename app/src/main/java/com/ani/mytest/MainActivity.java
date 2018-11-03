package com.ani.mytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        User user=new User("hihipip","0911111111",50,true);
        Gson gson = new Gson();
        Log.e("TEST","user="+gson.toJson(user));



        String userJson = "{\"username\":\"aaa\",\"phone\":\"000\",\"age\":0,\"sex\":true}";
        user = gson.fromJson(userJson, User.class);
        Log.e("TEST","user="+user);

        userJson = "{\"username\":\"bbb\",\"phone\":\"111\",\"age\":1,\"sex\":false}";
        user = gson.fromJson(userJson, User.class);
        Log.e("TEST","user="+user);


        /*
        userJson = "{\"name\":\"ccc\",\"phone\":\"222\",\"age\":2,\"sex\":false,\"zzz\":\"zzzzzz\"}";
        user = gson.fromJson(userJson, User.class);
        Log.e("TEST","user="+user);
        */
        userJson = "{\"name\":\"hihipip\",\"phone\":\"0952123456\",\"age\":30,\"sex\":true},{\"http_code\":\"200\"}";
        user = gson.fromJson(userJson, User.class);
        Log.e("TEST","user="+user);




    }
}




