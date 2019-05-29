package com.mosaiker.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("EUREKA-LOGIN")
public interface LoginClient {
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(@RequestParam String username, @RequestParam String password);
}