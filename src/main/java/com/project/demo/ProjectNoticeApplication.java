package com.project.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.project.demo.thread.MultiThread;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = "com.project")
// @EnableScheduling
public class ProjectNoticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectNoticeApplication.class, args);  
	}
}
