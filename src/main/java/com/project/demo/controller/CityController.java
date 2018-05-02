package com.project.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.dto.CityDTO;
import com.project.demo.dto.CityMayorDTO;
import com.project.demo.dto.MayorDTO;
import com.project.demo.dto.MessageDTO;
import com.project.demo.entity.CityMaster;
import com.project.demo.entity.MayorMaster;
import com.project.demo.service.ICityService;
import com.project.demo.service.ScheduledClassService;


@RestController
@RequestMapping("/")
public class CityController {
    
    @Autowired	
    ICityService cityService;
    
    @Autowired
    ScheduledClassService scheduledClass;

    @RequestMapping(value="/showCities",method=RequestMethod.GET)
    @ResponseBody
    public List<CityDTO> findCities() {       
        
        return  cityService.findAll();
    }
    
    @RequestMapping(value="/cityAdd",method=RequestMethod.POST)
    public List<CityMaster> addCity(@RequestBody List<CityDTO> jsonObj )
    {
    	return cityService.addCity(jsonObj);
    }
    
    @RequestMapping(value="/mayorAdd",method=RequestMethod.POST)
    public List<MayorMaster> addMayor(@RequestBody List<MayorDTO> jsonObj )
    {
    	return cityService.addMayor(jsonObj);
    }
   
    @RequestMapping(value="/showMayors",method=RequestMethod.GET)
    @ResponseBody
    public List<MayorDTO> findMayors() {       
        
        return  cityService.findMayors();
    }
    
    @RequestMapping(value="/city/mayor/add",method=RequestMethod.POST)
    public MessageDTO addCityMayor(@RequestBody List<CityMayorDTO> jsonObj )
    {
    	return cityService.addCityMayor(jsonObj);
    }
    
    
    /*@RequestMapping(value="/enableScheduling",method = RequestMethod.GET)
    public void checkScheduling() {
    	scheduledClass.display();
    }
    */
    
}
