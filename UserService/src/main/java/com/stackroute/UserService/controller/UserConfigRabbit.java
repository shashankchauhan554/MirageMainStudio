package com.stackroute.UserService.controller;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;



@Configuration
public class UserConfigRabbit {

    private String exchange = "Saloon_exchange";

    private String email_queue = "user_email_queue";
    private String auth_queue = "user_auth_queue";

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConvertor(){return new Jackson2JsonMessageConverter();}


    @Bean
    public DirectExchange exchange(){return new DirectExchange(exchange);}

    @Bean
    public Queue getEmailQueue() { return new Queue(email_queue); }

    @Bean
    public Queue getAuthQueue(){
        return new Queue(auth_queue);
    }

    @Bean
    public Binding bindingUser(){
        return  BindingBuilder.bind(getEmailQueue()).to(exchange()).with("thisisemailkey");
    }

    @Bean
    public Binding AuthBinding(){
        return  BindingBuilder.bind(getAuthQueue()).to(exchange()).with("thisisAuthkey");
    }
    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory)
    {
        RabbitTemplate rabtemp=new RabbitTemplate(connectionFactory);
        rabtemp.setMessageConverter(jsonMessageConvertor());
        return rabtemp;
    }
}
