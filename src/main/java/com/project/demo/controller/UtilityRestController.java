package com.project.demo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.service.AdhocService;
import com.project.demo.service.ThreadService;

@RestController
@RequestMapping("/api/v1/utilities")
public class UtilityRestController {

    @Autowired
    private ThreadService threadService;

    @Autowired
    private AdhocService adhocService;

    @PostMapping("/threads/start")
    public ResponseEntity<Boolean> startThreads() {
        boolean result = threadService.startThreads();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/json/flatten")
    public ResponseEntity<String> flattenJson(@RequestBody String jsonString) {
        String flattened = adhocService.getJsonFlat(new JSONObject(jsonString));
        return ResponseEntity.ok(flattened);
    }
}