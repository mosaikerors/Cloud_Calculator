package com.mosaiker.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/login")
    public String calculate(@RequestParam String username, @RequestParam String password) {
        String result = "";
        if (username.equals("yjy") && password.equals("777")) {
            result = "ok";
        } else {
            result = "fail";
        }
        logger.info("/login: " + result);
        return result;
    }
}
