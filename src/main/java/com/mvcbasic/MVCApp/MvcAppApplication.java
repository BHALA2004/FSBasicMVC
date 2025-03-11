package com.mvcbasic.MVCApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MvcAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(MvcAppApplication.class, args);
	}

}
