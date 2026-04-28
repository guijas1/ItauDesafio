package com.guijas1.ItauTech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ItauTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItauTechApplication.class, args);
	}

}
