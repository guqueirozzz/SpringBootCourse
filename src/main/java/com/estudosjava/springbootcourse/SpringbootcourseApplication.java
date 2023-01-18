package com.estudosjava.springbootcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.estudosjava.springbootcourse")
@SpringBootApplication
public class SpringbootcourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcourseApplication.class, args);
	}

}
