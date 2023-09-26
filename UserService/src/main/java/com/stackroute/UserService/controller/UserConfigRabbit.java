package com.stackroute.UserService.controller;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;



@Configuration
public class UserConfigRabbit {

    private String exchangeName = "user_exchange";

    private String registerName = "user_queue";

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConvertor(){return new Jackson2JsonMessageConverter();}


    @Bean
    public DirectExchange directExchange(){return new DirectExchange(exchangeName);}

    @Bean
    public Queue registerQueue() { return new Queue(registerName, false); }

    @Bean
    Binding bindingUser(Queue registerQueue, DirectExchange exchange){
        return  BindingBuilder.bind(registerQueue()).to(exchange).with("user_routing");
    }
}
