package com.stackroute.EmailService.configure;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.TopicExchange;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
@Configuration
public class RabbitMQConfig {
    private static final String QUEUE_NAME = "user_email_queue";
   @Bean
   public Queue queue() {
       return new Queue(QUEUE_NAME);
   }
}
