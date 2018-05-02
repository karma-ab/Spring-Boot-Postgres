package com.project.demo;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.demo.entity.CityMaster;
import com.project.demo.repository.CityRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class ProjectNoticeApplicationTests {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CityRepository cityRepository;

	@Test
	public void cityAddTest() {

		CityMaster cityMaster = new CityMaster((long) 100, "TestCity", 5000);
		CityMaster cityMasterTest = cityRepository.save(cityMaster);
		log.info("Test case execution in progress :: adding City and verifying");
		Assert.assertEquals(5000, cityMasterTest.getPopulation());

	}

}
