package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Controller {

    @PostMapping("/user")
    public String createUser(@RequestBody User user) {
        // 这里你可以处理用户信息，比如保存到数据库
        // 打印接收到的用户信息到控制台
        System.out.println(user);

        // 返回一个响应
        return "User received: " + user.toString();
    }
}