package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserById(Long id) {
        // 模拟一些处理
        try {
            Thread.sleep(100); // 模拟延迟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "User" + id;
    }
}

