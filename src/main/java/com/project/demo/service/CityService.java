package com.project.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.dto.CityDTO;
import com.project.demo.entity.CityEntity;
import com.project.demo.repository.CityRepository;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<CityDTO> findAll() {

        List<CityEntity> cities = (List<CityEntity>) cityRepository.findAll();
        List<CityDTO> cityDto = new ArrayList<CityDTO>();
        for(CityEntity city : cities) {
        	CityDTO obj = new CityDTO(city.getId(),city.getName(),city.getPopulation());
        	cityDto.add(obj);
        }
        
        return cityDto;
    }
}