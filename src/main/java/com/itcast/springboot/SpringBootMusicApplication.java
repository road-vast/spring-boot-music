package com.itcast.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//将该包下所有接口扫描装配为mapper接口
@MapperScan(value="com.itcast.springboot.mapper")
@SpringBootApplication
public class SpringBootMusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMusicApplication.class, args);
    }

}
