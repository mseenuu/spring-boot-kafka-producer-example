package com.techprimers.kafka.springbootkafkaproducerexample.service;


import com.techprimers.kafka.springbootkafkaproducerexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")

public class UserResource {
    @Autowired
    private KafkaTemplate<String, User>kafkaTemplate;
    private static final String TOPIC= "KafkaExample";
            @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name){
                //System.out.println(name);
            User user=    new User(name, "Technology", 20000L);
        kafkaTemplate.send(TOPIC, user);
        return "Published successfully";
            }
}
