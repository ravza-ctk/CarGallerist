package com.rvzctk.gallerist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rvzctk.gallerist")
public class GalleristApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalleristApplication.class, args);
	}

}
