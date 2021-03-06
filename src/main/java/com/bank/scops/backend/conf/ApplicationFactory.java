package com.bank.scops.backend.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class ApplicationFactory {

    @Bean
    public RestOperations gatewayRestTemplate(){
        return  new RestTemplate();
    }
}
