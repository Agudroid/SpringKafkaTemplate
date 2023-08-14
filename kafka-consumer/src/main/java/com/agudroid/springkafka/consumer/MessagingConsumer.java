package com.agudroid.springkafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessagingConsumer {

	private static final Logger log = LoggerFactory.getLogger(MessagingConsumer.class);
	
	@KafkaListener(topics = "agudroid_messages", groupId = "myGroup")
	public void consume(String eventMessage) {
		
		log.info(String.format("message received: %s", eventMessage));
		
		
	}
}
