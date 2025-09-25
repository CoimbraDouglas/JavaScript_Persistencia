package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.services.HelloController;

@SpringBootApplication
public class DemoApplication {


	private final HelloController helloController;

	public DemoApplication(HelloController helloController) {
		this.helloController = helloController;
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
