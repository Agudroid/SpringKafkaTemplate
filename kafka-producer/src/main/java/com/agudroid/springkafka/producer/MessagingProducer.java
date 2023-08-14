package com.agudroid.springkafka.producer;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.agudroid.springkafka.handler.MessageHandler;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class MessagingProducer {

	private static final Logger Log = LoggerFactory.getLogger(MessagingProducer.class);
	
	private KafkaTemplate<String, String> kafkaTemplate;

	public MessagingProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage() throws InterruptedException {
		String topic = "agudroid_messages";
		
		// We will read real time data from wikimedia as an example
		EventHandler eventHandler = new MessageHandler(kafkaTemplate, topic);
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";
		
		EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
		EventSource eventSource = builder.build();
		
		eventSource.start();
		TimeUnit.MINUTES.sleep(10);
		
	}
	
	
}
