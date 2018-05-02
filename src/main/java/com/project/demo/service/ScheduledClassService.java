package com.project.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ScheduledClassService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledClassService.class);

	// @Scheduled(fixedRate = 3000)
	public void display() {
		LOGGER.info("Hello There");
	}
}
