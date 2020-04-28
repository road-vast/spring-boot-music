package com.itcast.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Map;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    Environment environment;
    //为API配置分组
    @Bean
    public Docket docketUser(){
        //在dev和test的环境下才能访问dev：开发环境；test：测试环境
        Profiles profiles = Profiles.of("dev", "test");
        boolean isEnable = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                //为分组起名字
//                .groupName("用户")
                .select()
                //扫描对应的包
                .apis(RequestHandlerSelectors.basePackage("com.itcast.springboot.controller")).build()
                //该分组只显示/user路径下的
//                .paths(PathSelectors.ant("/user")).build()
                //忽略掉map类型的参数
                .ignoredParameterTypes(Map.class)
                //是否能被访问
                .enable(isEnable);
    }
}
