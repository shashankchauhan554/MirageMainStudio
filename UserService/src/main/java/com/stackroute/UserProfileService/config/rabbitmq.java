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
    private String exchangeName = "SaloonExchange";
    private String queue1 = "auth_Queue";
    private String queue2 = "email_Queue2";


    @Bean
    public DirectExchange getDirectExchange() {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Queue getQueue1() {
        return new Queue(queue1);
    }

    @Bean
    public Queue getQueue2() {
        return new Queue(queue2);
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
        return BindingBuilder.bind(getQueue1()).to(getDirectExchange()).with("thisIsAuthKey");
    }

    @Bean
    public Binding getBinding2() {
        return BindingBuilder.bind(getQueue2()).to(getDirectExchange()).with("thisIsEmailKey");
    }


}


