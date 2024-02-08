package com.stackroute.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/*
Add configuration annotation
 */
@Configuration
public class kafkaConfig {

    /*
    Build a new topic LOCATION_TOPIC_NAME
     */
    @Bean
    public NewTopic topic(){
    	String topicName=AppConstants.LOCATION_TOPIC_NAME;
    	return TopicBuilder.name(topicName)
    			.partitions(1)
    			.replicas(1)
    			.build();
    }
}
