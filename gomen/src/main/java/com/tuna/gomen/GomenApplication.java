package com.tuna.gomen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tuna.gomen.mapper")
public class GomenApplication {

    public static void main(String[] args) {
        SpringApplication.run(GomenApplication.class, args);
    }

}
