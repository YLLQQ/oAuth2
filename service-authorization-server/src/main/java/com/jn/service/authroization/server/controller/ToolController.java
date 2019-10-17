package com.jn.service.authroization.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToolController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/tool/bcrypt")
    public String bCryptPasswordEncoder(@RequestParam("password") String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
