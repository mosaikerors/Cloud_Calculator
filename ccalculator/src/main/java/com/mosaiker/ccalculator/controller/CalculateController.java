package com.mosaiker.ccalculator.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mosaiker.ccalculator.Entity.Line;
import com.mosaiker.ccalculator.service.calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.ServiceInstance;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CalculateController {
    private static final Logger logger = LoggerFactory.getLogger(CalculateController.class);

    @Autowired
    private DiscoveryClient discoveryClient;
//    @Autowired
//    private Registration registration; // 服务注册

    private calculator cal = new calculator();

    @PostMapping(value = "/calculate")
    public String calculate(@RequestBody JSONObject obj) {
//        ServiceInstance instance = discoveryClient.getInstances();
//        System.out.println(line.getLine());
//        String result = cal.cal(line.getLine());
//        logger.info("/calculate: "+line.getLine()+"  result: "+result);
        String line = obj.getString("line");
        System.out.println(line);
        String result = cal.cal(line);
        logger.info("/calculate: "+line+"  result: "+result);
        return result;
    }
}
