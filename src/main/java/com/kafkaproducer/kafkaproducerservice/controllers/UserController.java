package com.kafkaproducer.kafkaproducerservice.controllers;

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
    @Autowired
    KafkaTemplate<String, String> template;
    private static final String TOPIC="TestTopic";
    @GetMapping(value = "/user/{name}")
    public String post(@PathVariable("name") String name)
    {
        template.send(TOPIC, name);
        return "Message published";
    }

}
