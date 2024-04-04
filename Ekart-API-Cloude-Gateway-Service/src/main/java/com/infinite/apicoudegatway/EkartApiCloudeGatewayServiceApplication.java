package com.infinite.apicoudegatway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
//import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class EkartApiCloudeGatewayServiceApplication {

	public static void main(String[] args) {
		System.out.println("AAA");
		SpringApplication.run(EkartApiCloudeGatewayServiceApplication.class, args);
	}

}
