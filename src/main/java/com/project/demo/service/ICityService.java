package com.project.demo.service;

import java.util.List;

import com.project.demo.dto.CityDTO;
import com.project.demo.entity.CityEntity;

public interface ICityService {

    public List<CityDTO> findAll();
}