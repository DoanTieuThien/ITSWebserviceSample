package com.its.webservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author tuannx2
 *
 */
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.its.webservice.*")
public class ITSWebserviceBootApp {
	public static void main(String[] args) {
		SpringApplication.run(ITSWebserviceBootApp.class, "");
	}
}
