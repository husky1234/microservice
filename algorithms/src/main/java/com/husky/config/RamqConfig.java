package com.husky.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RamqConfig {
    public final static String man = "topic.man";
    public final static String woman = "topic.woman";

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            System.out.println("ConfirmCallback:     "+"相关数据："+correlationData);
            System.out.println("ConfirmCallback:     "+"确认情况："+ack);
            System.out.println("ConfirmCallback:     "+"原因："+cause);
        });
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            System.out.println("ReturnCallback:     "+"消息："+message);
            System.out.println("ReturnCallback:     "+"回应码："+replyCode);
            System.out.println("ReturnCallback:     "+"回应信息："+replyText);
            System.out.println("ReturnCallback:     "+"交换机："+exchange);
            System.out.println("ReturnCallback:     "+"路由键："+routingKey);
        });
        return rabbitTemplate;
    }
    @Bean
    public Queue rabbitMqQueue(){
        return new Queue("testqueue");
    }
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("testexchange",false,true);
    }
    @Bean
    Binding bindingDirect(){
        return BindingBuilder.bind(rabbitMqQueue()).to(directExchange()).with("test");
    }
    @Bean
    public Queue firstQueue(){
        return new Queue(RamqConfig.man);
    }
    @Bean Queue secondQueue(){
        return new Queue(RamqConfig.woman);
    }
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("topicExchange");
    }
    @Bean
    Binding bindingExchangeMessage(){
        return BindingBuilder.bind(firstQueue()).to(exchange()).with(man);
    }
    @Bean
    Binding bindingExchangemessage2(){
        return BindingBuilder.bind(secondQueue()).to(exchange()).with("topic.#");
    }
}
