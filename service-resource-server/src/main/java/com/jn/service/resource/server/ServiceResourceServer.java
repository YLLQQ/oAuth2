package com.jn.service.resource.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@SpringBootApplication
public class ServiceResourceServer {
    public static void main(String[] args) {
        SpringApplication.run(ServiceResourceServer.class, args);
    }
}
