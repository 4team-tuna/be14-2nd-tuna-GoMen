package com.tuna.gomen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.tuna.gomen")
public class GomenApplication {

    public static void main(String[] args) {
        SpringApplication.run(GomenApplication.class, args);
    }

}
