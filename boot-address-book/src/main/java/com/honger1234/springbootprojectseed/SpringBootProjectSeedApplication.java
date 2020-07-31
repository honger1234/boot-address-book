package com.honger1234.springbootprojectseed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.honger1234.springbootprojectseed.dao")
public class SpringBootProjectSeedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectSeedApplication.class, args);
    }

}
