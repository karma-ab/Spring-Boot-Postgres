package com.project.demo.service;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.dto.MongoUserDTO;
import com.project.demo.mongoEntity.UserEntity;
import com.project.demo.repository.MongoUserRepo;
import com.project.demo.service.interfaces.IMongoService;

@Service
public class MongoService implements IMongoService {
	
	@Autowired
	MongoUserRepo mongoUserRepo;

	@Override
	public List<MongoUserDTO> getUsers() {
		List<UserEntity> userList = mongoUserRepo.findAll();
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<MongoUserDTO>>() {
		}.getType();
		return mapper.map(userList, listType);
	}

	@Override
	public List<MongoUserDTO> saveUsers(List<MongoUserDTO> mongoUsers) {
		
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<UserEntity>>() {
		}.getType();
		List<UserEntity> userEnities = mapper.map(mongoUsers, listType);
		
		Type listTypeDTO = new TypeToken<List<MongoUserDTO>>() {
		}.getType();
		
		userEnities = mongoUserRepo.saveAll(userEnities);
		
		return mapper.map(userEnities, listTypeDTO);
		
	}

}
