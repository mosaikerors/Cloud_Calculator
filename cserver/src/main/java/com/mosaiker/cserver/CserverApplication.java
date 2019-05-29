package com.mosaiker.cserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(CserverApplication.class, args);
    }

}
