package com.ertu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author jazz-hxf
 */
@SpringBootApplication
public class ErTuSpiderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErTuSpiderApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
