package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.dto.CityDTO;
import com.project.demo.dto.CityMayorDTO;
import com.project.demo.dto.MessageDTO;
import com.project.demo.entity.CityMaster;
import com.project.demo.service.interfaces.ICityService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/cities")
public class CityRestController {

    @Autowired
    private ICityService cityService;

    @GetMapping
    public ResponseEntity<List<CityDTO>> getAllCities() {
        List<CityDTO> cities = cityService.findAll();
        return ResponseEntity.ok(cities);
    }

    @PostMapping
    public ResponseEntity<List<CityMaster>> createCities(@Valid @RequestBody List<CityDTO> cities) {
        List<CityMaster> createdCities = cityService.addCity(cities);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCities);
    }

    @PostMapping("/{cityId}/mayors")
    public ResponseEntity<MessageDTO> assignMayorToCity(@PathVariable Long cityId, @Valid @RequestBody List<CityMayorDTO> cityMayors) {
        // Update the cityMayors to include the cityId from path
        cityMayors.forEach(cm -> cm.setCityId(cityId));
        MessageDTO result = cityService.addCityMayor(cityMayors);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}