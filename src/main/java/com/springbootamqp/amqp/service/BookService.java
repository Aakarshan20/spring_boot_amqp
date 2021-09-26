package com.springbootamqp.amqp.service;

import com.springbootamqp.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = "China")
    public void receive(Book book){
        System.out.println("收到消息:" + book);
    }

    @RabbitListener(queues = "China.news")
    public void receiveHeader(Message message){
        System.out.println("收到消息Body:" + message.getBody());
        System.out.println("收到消息Properties:" + message.getMessageProperties());
    }
}
