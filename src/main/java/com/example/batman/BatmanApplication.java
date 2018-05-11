package com.example.batman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BatmanApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatmanApplication.class, args);
    }
}
