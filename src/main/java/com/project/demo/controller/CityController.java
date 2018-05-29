package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.dto.AssetDTO;
import com.project.demo.dto.CityDTO;
import com.project.demo.dto.CityMayorDTO;
import com.project.demo.dto.MayorDTO;
import com.project.demo.dto.MessageDTO;
import com.project.demo.dto.MongoUserDTO;
import com.project.demo.entity.AssetInventory;
import com.project.demo.entity.CityMaster;
import com.project.demo.entity.MayorMaster;
import com.project.demo.service.AssetService;
import com.project.demo.service.MongoService;
import com.project.demo.service.ScheduledClassService;
import com.project.demo.service.ThreadService;
import com.project.demo.service.interfaces.ICityService;

@RestController
@RequestMapping("/")
public class CityController {

	@Autowired
	ICityService cityService;

	@Autowired
	ScheduledClassService scheduledClass;
	
	@Autowired
	AssetService assetService;
	
	@Autowired
	MongoService mongoService;
	
	@Autowired
	ThreadService threadService;

	@RequestMapping(value = "/showCities", method = RequestMethod.GET)
	@ResponseBody
	public List<CityDTO> findCities() {

		return cityService.findAll();
	}

	@RequestMapping(value = "/cityAdd", method = RequestMethod.POST)
	public List<CityMaster> addCity(@RequestBody List<CityDTO> jsonObj) {
		return cityService.addCity(jsonObj);
	}

	@RequestMapping(value = "/mayorAdd", method = RequestMethod.POST)
	public List<MayorMaster> addMayor(@RequestBody List<MayorDTO> jsonObj) {
		return cityService.addMayor(jsonObj);
	}

	@RequestMapping(value = "/showMayors", method = RequestMethod.GET)
	@ResponseBody
	public List<MayorDTO> findMayors() {

		return cityService.findMayors();
	}

	@RequestMapping(value = "/city/mayor/add", method = RequestMethod.POST)
	public MessageDTO addCityMayor(@RequestBody List<CityMayorDTO> jsonObj) {
		return cityService.addCityMayor(jsonObj);
	}

	@RequestMapping(value="/sortAsset")
	public List<AssetDTO> sortAsset()
	{
		return assetService.sortAsset();
	}
	
	
	@RequestMapping(value="/fetchUsers")
	public List<MongoUserDTO> getUsers()
	{
		return mongoService.getUsers();
	}
	

	@RequestMapping(value="/saveUsers",method = RequestMethod.POST)
	public List<MongoUserDTO> saveUsers(@RequestBody List<MongoUserDTO> userObj)
	{
		return mongoService.saveUsers(userObj);
	}
	
	@RequestMapping(value="/startThreads")
	public boolean startThreads()
	{
		return threadService.startThreads();
	}
	/*
	 * @RequestMapping(value="/enableScheduling",method = RequestMethod.GET) public
	 * void checkScheduling() { scheduledClass.display(); }
	 */

}
