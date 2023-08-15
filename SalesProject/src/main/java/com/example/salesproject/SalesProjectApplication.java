package com.example.salesproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SalesProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesProjectApplication.class, args);
    }

}
