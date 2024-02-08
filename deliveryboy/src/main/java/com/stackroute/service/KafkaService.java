package com.stackroute.service;


import com.stackroute.config.AppConstants;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    
    @Autowired
    private NewTopic locationTopic;

    private Logger logger= LoggerFactory.getLogger(KafkaService.class);

    /*
    Method to trigger kafka send
     */
    public boolean updateLocation(String location){
        // Send location using kafka send() providing appropriate topic name
    	kafkaTemplate.send(locationTopic.name(), location);

        this.logger.info("location produced");
        return true;
    }
}
