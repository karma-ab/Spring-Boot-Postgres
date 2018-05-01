package com.project.demo.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.dto.CityDTO;
import com.project.demo.dto.MayorDTO;
import com.project.demo.entity.CityMaster;
import com.project.demo.entity.MayorMaster;
import com.project.demo.repository.CityRepository;
import com.project.demo.repository.MayorRepository;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository cityRepository;
    
    @Autowired
    private MayorRepository mayorRepository;

    @Override
    public List<CityDTO> findAll() {

        List<CityMaster> cities = (List<CityMaster>) cityRepository.findAll();
        List<CityDTO> cityDto = new ArrayList<CityDTO>();
        for(CityMaster city : cities) {
        	CityDTO obj = new CityDTO(city.getId(),city.getName(),city.getPopulation());
        	cityDto.add(obj);
        }
        
        return cityDto;
    }

	@Override
	public List<CityMaster> addCity(List<CityDTO> cityList) {
		List<CityMaster> cities ;
		
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<CityMaster>>() {}.getType();
		cities = mapper.map(cityList,listType);
		cityRepository.saveAll(cities);
		/*cityList.forEach(city->{
			CityMaster cityPersist = new CityMaster();
			cityPersist.setName(city.getName());
			cityPersist.setPopulation(city.getPopulation());	
			cities.add(cityRepository.save(cityPersist));
		});
*/		return cities;
	}

	@Override
	public List<MayorMaster> addMayor(List<MayorDTO> mayorList) {
		List<MayorMaster> mayors = new ArrayList<>() ;
		
		/*ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<MayorMaster>>() {}.getType();
		mayors = mapper.map(mayorList,listType);
		 mayorRepository.saveAll(mayors);*/
		 
		 mayorList.forEach(mayor->{
			 MayorMaster mayorPersist = new MayorMaster();
			 mayorPersist.setName(mayor.getName());
			 mayorPersist.setAge(mayor.getAge());	
			 mayors.add(mayorRepository.save(mayorPersist));
			});
		 
		 return mayors;
	}
}