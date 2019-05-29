package com.mosaiker.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.consumer.service.CalculateClient;
import com.mosaiker.consumer.service.LoginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @PostMapping(value = "/calculate")
    public String calculate(HttpServletRequest request) {
        String line = request.getParameter("line");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("eureka-calculator");
        if (loginClient.login(username, password).equals("ok")) {
            System.out.println("Eureka info:>>>>"+serviceInstance.getServiceId()+":"+serviceInstance.getHost()+":"+serviceInstance.getPort());
            JSONObject object = new JSONObject();
            object.put("line", line);
            return calculateClient.calculate(object);
        }
        return "login fail";
    }
}
