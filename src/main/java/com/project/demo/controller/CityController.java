package com.project.demo.controller;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.dto.CityDTO;
import com.project.demo.entity.CityEntity;
import com.project.demo.service.ICityService;
import com.project.demo.service.ScheduledClassService;

@RestController
public class CityController {
    
    @Autowired	
    ICityService cityService;
    
    @Autowired
    ScheduledClassService scheduledClass;

    @RequestMapping(value="/showCities",method=RequestMethod.GET)
    @ResponseBody
    public List<CityDTO> findCities() {
        
        List<CityDTO> cities = (List<CityDTO>) cityService.findAll();
       
        
        return cities;
    }
    
    /*@RequestMapping(value="/enableScheduling",method = RequestMethod.GET)
    public void checkScheduling() {
    	scheduledClass.display();
    }
    */
    
}
