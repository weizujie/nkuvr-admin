package com.nkuvr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.nkuvr.dao")
@ComponentScan(basePackages = "com.nkuvr.*")
public class NkuvrAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(NkuvrAdminApplication.class, args);
    }

}
