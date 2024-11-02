package com.example.libraryapp.config;

import com.example.libraryapp.constants.RabbitMQQueueConstants;
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
        return new Queue(RabbitMQQueueConstants.BOOK_CREATE_QUEUE);
    }

    @Bean
    public Queue updateQueue() {
        return new Queue(RabbitMQQueueConstants.BOOK_UPDATE_QUEUE);
    }

    @Bean
    public Queue deleteQueue() {
        return new Queue(RabbitMQQueueConstants.BOOK_DELETE_QUEUE);
    }

    @Bean
    public Queue errorQueue() {
        return new Queue(RabbitMQQueueConstants.ERROR_QUEUE, true);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}