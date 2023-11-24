package com.example.demo.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.example.demo.entity.*;
@RestController
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
 //逻辑一 仅为管理员
        if ("admin".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            return ResponseEntity.ok("登录成功");
        } else {
            return ResponseEntity.status(401).body("登录失败");
        }
    }
}


