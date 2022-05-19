package com.shutiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.shutiao.mapper")
@EnableScheduling
public class ShuTiaoBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShuTiaoBlogApplication.class,args);
    }
}