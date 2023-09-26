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

    private String exchange = "user_exchange";

    private String queue = "user_queue";

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConvertor(){return new Jackson2JsonMessageConverter();}


    @Bean
    public DirectExchange exchange(){return new DirectExchange(exchange);}

    @Bean
    public Queue registerQueue() { return new Queue(queue); }

    @Bean
    Binding bindingUser(Queue registerQueue, DirectExchange exchange){
        return  BindingBuilder.bind(registerQueue()).to(exchange).with("user_routing");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory)
    {
        RabbitTemplate rabtemp=new RabbitTemplate(connectionFactory);
        rabtemp.setMessageConverter(jsonMessageConvertor());
        return rabtemp;
    }
}
