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

}
