package com.kafkaproducer.kafkaproducerservice.controllers;
import com.kafkaproducer.kafkaproducerservice.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
class UserController 
{
    
    KafkaTemplate<String, Users> kafkaTemplate;
    private static final String TOPIC="TestTopic";

    @Autowired
    public UserController(KafkaTemplate<String, Users> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;

    }

    @GetMapping(value = "/user/{name}")
    public String post(@PathVariable("name") String name)
    {
        kafkaTemplate.send(TOPIC, new Users("123", name, "qeqwed"));
        return "Message published";
    }

}
