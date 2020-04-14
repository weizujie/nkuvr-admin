package com.nkuvr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@MapperScan("com.nkuvr.dao")
public class NkuvrAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(NkuvrAdminApplication.class, args);
    }

}
