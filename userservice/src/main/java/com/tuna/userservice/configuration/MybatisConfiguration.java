package com.tuna.userservice.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.tuna.userservice", annotationClass = Mapper.class)
public class MybatisConfiguration {
}
