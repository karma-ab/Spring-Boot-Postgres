package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.dto.AssetDTO;
import com.project.demo.service.AssetService;

@RestController
@RequestMapping("/api/v1/assets")
public class AssetRestController {

    @Autowired
    private AssetService assetService;

    @GetMapping
    public ResponseEntity<List<AssetDTO>> getAssets(
            @RequestParam(value = "sort", defaultValue = "price") String sortBy) {
        List<AssetDTO> assets = assetService.sortAsset();
        return ResponseEntity.ok(assets);
    }
}