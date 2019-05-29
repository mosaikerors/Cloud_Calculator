package com.mosaiker.ccalculator.controller;

import com.alibaba.fastjson.JSONObject;
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

@RestController
public class CalculateController {
    private static final Logger logger = LoggerFactory.getLogger(CalculateController.class);

    private calculator cal = new calculator();

    @PostMapping(value = "/calculate")
    public String calculate(@RequestBody JSONObject obj) {
        String line = obj.getString("line");
        System.out.println(line);
        String result = cal.cal(line);
        logger.info("/calculate: "+line+"  result: "+result);
        return result;
    }
}
