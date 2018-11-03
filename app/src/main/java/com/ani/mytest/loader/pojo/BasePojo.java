package com.ani.mytest.loader.pojo;

import java.io.Serializable;

/**
 * Created by ghost on 2018/11/3.
 */

public class BasePojo implements Serializable {
    private int http_code;
    private boolean isok=false; //判斷是否OK

    public int getHttp_code() {
        return http_code;
    }
    public void setHttp_code(int http_code) {
        this.http_code = http_code;
    }
    public boolean isIsok() {
        return isok;
    }
    public void setIsok(boolean isok) {
        this.isok = isok;
    }
}
