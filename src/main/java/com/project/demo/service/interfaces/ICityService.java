package com.project.demo.service.interfaces;

import java.util.List;

import com.project.demo.dto.CityDTO;
import com.project.demo.dto.CityMayorDTO;
import com.project.demo.dto.MayorDTO;
import com.project.demo.dto.MessageDTO;
import com.project.demo.entity.CityMaster;
import com.project.demo.entity.MayorMaster;

public interface ICityService {

	public List<CityDTO> findAll();

	public List<MayorDTO> findMayors();

	public List<CityMaster> addCity(List<CityDTO> cityList);

	public List<MayorMaster> addMayor(List<MayorDTO> mayorList);

	public MessageDTO addCityMayor(List<CityMayorDTO> obj);
}