package com.oasis.apigestmenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApiGestMenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGestMenuApplication.class, args);
	}
/*
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.tutorialspoint.swaggerdemo")).build();
	}
*/
}
