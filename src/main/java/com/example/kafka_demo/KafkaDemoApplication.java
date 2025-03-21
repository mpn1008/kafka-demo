package com.example.kafka_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@SpringBootApplication
public class KafkaDemoApplication {

	public static void main(String[] args) {

//		TransactionAspectSupport.currentTransactionStatus();

		SpringApplication.run(KafkaDemoApplication.class, args);
	}

}
