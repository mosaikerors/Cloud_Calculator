package com.mosaiker.consumer.service;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.consumer.Entity.Line;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@FeignClient("EUREKA-CALCULATOR")
public interface CalculateClient {
    @RequestMapping(method = RequestMethod.POST, value = "/calculate")
    public String calculate(JSONObject obj);
}
