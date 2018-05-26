package com.project.demo.service.interfaces;

import java.util.List;

import com.project.demo.dto.MongoUserDTO;

public interface IMongoService {

	public List<MongoUserDTO> getUsers();
	public List<MongoUserDTO> saveUsers(List<MongoUserDTO> mongoUsers);
}
