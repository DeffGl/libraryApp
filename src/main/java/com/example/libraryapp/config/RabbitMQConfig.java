package com.example.libraryapp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

    @Bean
    public Queue createQueue() {
        return new Queue("book_create_queue");
    }

    @Bean
    public Queue updateQueue() {
        return new Queue("book_update_queue");
    }

    @Bean
    public Queue deleteQueue() {
        return new Queue("book_delete_queue");
    }

    @Bean
    public Queue errorQueue() {
        return new Queue("error_queue", true);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}