package com.mosaiker.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.consumer.Entity.Line;
import com.mosaiker.consumer.service.CalculateClient;
import com.mosaiker.consumer.service.LoginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ConsumerController {
    @Autowired
    private CalculateClient calculateClient;

    @Autowired
    private LoginClient loginClient;

    @PostMapping(value = "/calculate")
    public String calculate(HttpServletRequest request) {
        String line = request.getParameter("line");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        System.out.println(line);
        if (loginClient.login(username, password).equals("ok")) {
            System.out.println("login ok");
            Line myLine = new Line(line);
            System.out.println(myLine.getLine());
//            return calculateClient.calculate(myLine);
            JSONObject object = new JSONObject();
            object.put("line", line);
            return calculateClient.calculate(object);
        }
        return "login fail";
    }
}
