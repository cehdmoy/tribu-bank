package com.bank.scops.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class BankScopBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankScopBackendApplication.class, args);
    }

}
