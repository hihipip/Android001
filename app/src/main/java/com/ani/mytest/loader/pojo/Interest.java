package com.ani.mytest.loader.pojo;

/**
 * Created by ghost on 2018/11/3.
 */

public class Interest {
    private String ball;
    private String running;

    public String getBall() {
        return ball;
    }

    public void setBall(String ball) {
        this.ball = ball;
    }

    public String getRunning() {
        return running;
    }

    public void setRunning(String running) {
        this.running = running;
    }

    @Override
    public String toString() {
        return "Interest{" +
                "ball='" + ball + '\'' +
                ", running='" + running + '\'' +
                '}';
    }
}
