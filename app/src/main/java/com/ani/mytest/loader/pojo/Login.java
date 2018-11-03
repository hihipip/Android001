package com.ani.mytest.loader.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ghost on 2018/11/3.
 */

public class Login extends BasePojo {

    @SerializedName(value = "username", alternate = {"user_name", "name"})
    private String name="";
    private String phone="";
    private int age=0;
    private boolean sex=false;

    public Login(String name, String phone, int age, boolean sex) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Login{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }


}
