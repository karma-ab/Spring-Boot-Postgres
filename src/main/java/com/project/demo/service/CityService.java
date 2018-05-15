package com.project.demo.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.dto.CityDTO;
import com.project.demo.dto.CityMayorDTO;
import com.project.demo.dto.MayorDTO;
import com.project.demo.dto.MessageDTO;
import com.project.demo.entity.CityMaster;
import com.project.demo.entity.CityMayor;
import com.project.demo.entity.MayorMaster;
import com.project.demo.repository.CityMayorRepository;
import com.project.demo.repository.CityRepository;
import com.project.demo.repository.MayorRepository;

@Service
public class CityService implements ICityService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private MayorRepository mayorRepository;

	@Autowired
	private CityMayorRepository cityMayorRepository;

	@Override
	public List<CityDTO> findAll() {

		List<CityMaster> cities = (List<CityMaster>) cityRepository.findAll();		
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<CityDTO>>() {
		}.getType();
		log.info("City returned to the user");
		return mapper.map(cities, listType);
	}

	@Override
	public List<CityMaster> addCity(List<CityDTO> cityList) {
		List<CityMaster> cities;

		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<CityMaster>>() {
		}.getType();
		cities = mapper.map(cityList, listType);
		cityRepository.saveAll(cities);
		log.info("Cities added to the database");
		return cities;
	}

	@Override
	public List<MayorMaster> addMayor(List<MayorDTO> mayorList) {
		List<MayorMaster> mayors = new ArrayList<>();
		mayorList.forEach(mayor -> {
			MayorMaster mayorPersist = new MayorMaster();
			mayorPersist.setName(mayor.getName());
			mayorPersist.setAge(mayor.getAge());
			mayors.add(mayorRepository.save(mayorPersist));
		});

		return mayors;
	}

	@Override
	public List<MayorDTO> findMayors() {
		List<MayorMaster> mayors = (List<MayorMaster>) mayorRepository.findAll();
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<MayorDTO>>() {}.getType();
		log.info("Mayors List returned");
		return mapper.map(mayors, listType);
	}

	@Override
	public MessageDTO addCityMayor(List<CityMayorDTO> obj) {

		obj.forEach(cityMayor -> 
			cityMayorRepository.save(new CityMayor(cityRepository.findById(cityMayor.getCityId()).get(),
					mayorRepository.findById(cityMayor.getMayorId()).get()))
		);
		return new MessageDTO("insertSuccessful");
	}
}