package com.agudroid.springkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.agudroid.springkafka.producer.MessagingProducer;

@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner{

	@Autowired
	private MessagingProducer producer;

	
	
	public static void main(String[] args){
		SpringApplication.run(SpringBootProducerApplication.class);

	}

	
	@Override
	public void run(String... args) throws Exception {
		
		producer.sendMessage();
	}

}
