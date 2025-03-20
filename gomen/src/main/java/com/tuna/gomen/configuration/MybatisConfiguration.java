package com.tuna.gomen.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.tuna.gomen", annotationClass = Mapper.class)
public class MybatisConfiguration {
}
