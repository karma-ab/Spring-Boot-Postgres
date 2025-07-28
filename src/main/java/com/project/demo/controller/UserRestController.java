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

import com.project.demo.dto.MongoUserDTO;
import com.project.demo.service.MongoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    @Autowired
    private MongoService mongoService;

    @GetMapping
    public ResponseEntity<List<MongoUserDTO>> getAllUsers() {
        List<MongoUserDTO> users = mongoService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<List<MongoUserDTO>> createUsers(@Valid @RequestBody List<MongoUserDTO> users) {
        List<MongoUserDTO> createdUsers = mongoService.saveUsers(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUsers);
    }
}