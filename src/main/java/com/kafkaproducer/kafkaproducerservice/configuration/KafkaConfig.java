package com.kafkaproducer.kafkaproducerservice.configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.kafkaproducer.kafkaproducerservice.models.Users;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaConfig {

    
    
    @Bean 
    public ProducerFactory<String, Users> producerFactory()
    {
        Map<String, Object> config= new HashMap<>();
        
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, Users> kafkaTemplate()
    {
        return new KafkaTemplate<>(producerFactory());
    }

}

