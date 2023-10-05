package com.stackroute.UserProfileService.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class rabbitmq {
    private String exchange = "SaloonExchange";
    private String Auth_Queue = "auth_Queue";
    private String Email_Queue = "email_Queue";


    @Bean
    public DirectExchange getDirectExchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Queue getAuthQueue() {
        return new Queue(Auth_Queue);
    }

    @Bean
    public Queue getEmailQueue() {
        return new Queue(Email_Queue);
    }



    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate getRabbitTemplate(final ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Binding getBinding1() {
        return BindingBuilder.bind(getAuthQueue()).to(getDirectExchange()).with("thisIsAuthKey");
    }

    @Bean
    public Binding getBinding2() {
        return BindingBuilder.bind(getEmailQueue()).to(getDirectExchange()).with("thisIsEmailKey");
    }


}


