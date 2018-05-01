package com.project.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages="com.project")
//@EnableWebMvc
//@EnableScheduling
public class ProjectNoticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectNoticeApplication.class, args);
	}
}
