package com.stackroute.EmailService.configure;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.TopicExchange;
@Configuration
public class RabbitMQConfig {
    public static final String USER_EXCHANGE = "Saloon_exchange";
    public static final String USER_QUEUE = "user_email_queue";
    public static  String emailQueue;
    public static String emailExchange;
    @Bean
    public Queue emailQueue() {
        return new Queue(USER_QUEUE);

    }
    @Bean
    public TopicExchange emailExchange() {
        return new TopicExchange(USER_EXCHANGE);}
}
