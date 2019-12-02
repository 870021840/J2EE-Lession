package com.dgut.domain;

public class Account {

    //用户名
    private  String username;
    //账户余额
    private Float money;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Account(String username, Float money) {
        this.username = username;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", money=" + money +
                '}';
    }

}
