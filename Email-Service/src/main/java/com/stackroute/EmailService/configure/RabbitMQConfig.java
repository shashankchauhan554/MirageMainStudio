package com.stackroute.EmailService.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
@Configuration
public class RabbitMQConfig {
    @Bean
    public Jackson2JsonMessageConverter getJackson2JsonMessageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }
}
