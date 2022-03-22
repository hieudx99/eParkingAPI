package com.example.eparking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EParkingApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EParkingApplication.class, args);
    }

}
