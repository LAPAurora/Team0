package com.example.demo.entity;
public class User {
    private String username;
    private String password; // 实际使用时，应确保密码不是明文存储或传输

    String getUsername() {
    	return username;
    }
    String getPassword() {
    	return password;
    }
}

