package com.ani.mytest.loader.pojo;


public class Member extends BasePojo {
    private String name;
    private Interest interest;
    private int money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Interest getInterest() {
        return interest;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", interest=" + interest +
                ", money=" + money +
                '}';
    }
}
