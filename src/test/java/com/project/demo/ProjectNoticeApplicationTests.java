package com.project.demo;

import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.project.demo.entity.CityMaster;
import com.project.demo.repository.CityRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@Rollback(true)
class ProjectNoticeApplicationTests {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CityRepository cityRepository;

	@Test
	void cityAddTest() {
		CityMaster cityMaster = new CityMaster((long) 100, "TestCity", 5000);
		CityMaster cityMasterTest = cityRepository.save(cityMaster);
		log.info("Test case execution in progress :: adding City and verifying");
		assertEquals(5000, cityMasterTest.getPopulation());
	}

}
