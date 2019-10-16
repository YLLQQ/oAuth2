package com.jn.service.authroization.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableWebSecurity
@EnableAuthorizationServer
@SpringBootApplication
public class ServiceAuthorizationServer {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthorizationServer.class, args);
    }
}
