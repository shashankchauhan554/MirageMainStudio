package com.stackroute.AuthenticationService.config;


import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {

    @Bean
    public Jackson2JsonMessageConverter getJackson2JsonMessageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }
}
