package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan("com.example.demo")
public class OldneighborhoodGoodManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OldneighborhoodGoodManagementApplication.class, args);
	}
}
