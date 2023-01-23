package com.miniProject.photoDatabse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PhotoDatabseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoDatabseApplication.class, args);
	}

}
