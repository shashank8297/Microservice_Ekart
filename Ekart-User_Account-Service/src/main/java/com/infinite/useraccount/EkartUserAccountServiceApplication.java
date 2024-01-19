package com.infinite.useraccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EkartUserAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkartUserAccountServiceApplication.class, args);
	}

}
