package com.project.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages="com.project.demo")
public class ProjectNoticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectNoticeApplication.class, args);
	}
}
