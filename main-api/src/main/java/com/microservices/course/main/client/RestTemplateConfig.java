package com.microservices.course.main.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.time.Duration;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        long TIMEOUT = 300000;
        return builder.setConnectTimeout(Duration.ofMillis(TIMEOUT))
                .setReadTimeout(Duration.ofMillis(TIMEOUT)).build();
    }
}
