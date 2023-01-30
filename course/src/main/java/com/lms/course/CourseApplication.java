package com.lms.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApplication {


	public static void main(String[] args) {
		try {
			SpringApplication.run(CourseApplication.class, args);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
