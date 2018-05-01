package com.project.demo.service;

import java.util.List;

import org.json.JSONObject;

import com.project.demo.dto.CityDTO;
import com.project.demo.dto.MayorDTO;
import com.project.demo.entity.CityMaster;
import com.project.demo.entity.MayorMaster;

public interface ICityService {

    public List<CityDTO> findAll();
    public List<CityMaster> addCity(List<CityDTO> cityList);
    public List<MayorMaster> addMayor(List<MayorDTO> mayorList);
}