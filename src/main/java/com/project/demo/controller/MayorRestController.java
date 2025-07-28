package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.dto.MayorDTO;
import com.project.demo.entity.MayorMaster;
import com.project.demo.service.interfaces.ICityService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/mayors")
public class MayorRestController {

    @Autowired
    private ICityService cityService;

    @GetMapping
    public ResponseEntity<List<MayorDTO>> getAllMayors() {
        List<MayorDTO> mayors = cityService.findMayors();
        return ResponseEntity.ok(mayors);
    }

    @PostMapping
    public ResponseEntity<List<MayorMaster>> createMayors(@Valid @RequestBody List<MayorDTO> mayors) {
        List<MayorMaster> createdMayors = cityService.addMayor(mayors);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMayors);
    }
}