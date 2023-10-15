package com.manning.sbip.ch03.model;

import com.manning.sbip.ch03.validation.Password;

public class User {

    private final String name;

    @Password
    private final String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }


    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
            "name='" + name + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}