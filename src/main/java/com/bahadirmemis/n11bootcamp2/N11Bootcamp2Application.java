package com.bahadirmemis.n11bootcamp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableFeignClients
@EnableAsync
public class N11Bootcamp2Application {

	public static void main(String[] args) {
		SpringApplication.run(N11Bootcamp2Application.class, args);
	}

}
