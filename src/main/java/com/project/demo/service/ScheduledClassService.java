package com.project.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledClassService {

	@Scheduled(fixedRate = 3000)
	public void display()
	{
		System.out.println("Hello There");
	}
}
