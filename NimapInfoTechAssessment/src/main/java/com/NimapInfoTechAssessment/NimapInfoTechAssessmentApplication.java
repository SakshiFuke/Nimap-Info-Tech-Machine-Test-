package com.NimapInfoTechAssessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.NimapInfoTechAssessment")
public class NimapInfoTechAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(NimapInfoTechAssessmentApplication.class, args);
	}

}
