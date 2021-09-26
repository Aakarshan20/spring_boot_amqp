package com.springbootamqp.amqp;

import com.springbootamqp.amqp.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        // 使用這個 可以自動生成Message Object
        // 發送一個字串
        // rabbitTemplate.convertAndSend("exchange.direct", "US.news", "SpringBoot來的信息");

        // 發送一個Object
        rabbitTemplate.convertAndSend("exchange.direct", "China", new Book("新刑法總論","林鈺雄"));

    }

    /**
     * 廣播
     */
    @Test
    void contextLoadsFanout() {
        // 發送一個Object
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("七龍珠2","鳥山明"));

    }

    @Test
    void receive(){
        Object object = rabbitTemplate.receiveAndConvert("US.news");
        System.out.println(object.getClass());
        System.out.println(object);
    }

}
