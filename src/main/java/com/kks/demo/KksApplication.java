package com.kks.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class KksApplication {
	public static void main(String[] args) {
		SpringApplication.run(KksApplication.class, args);
	}

	//http://localhost:8080/로 접속
}
