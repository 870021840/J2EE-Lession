package com.dgut.domain;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    Integer id;
    String username;
    String address;
    /**
     * 一个用户包含多个账户
     */
    List<Account> accounts;

    /**
     * 一个用户包含多个角色
     */
    List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", accounts=" + accounts +
                ", roles=" + roles +
                '}';
    }
}
