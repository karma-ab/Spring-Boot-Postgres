package com.project.demo.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MongoUserDTO {

	private String userId;
	private String name;
	private Date creationDate = new Date();
	private Map<String, String> userSettings = new HashMap<>();
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Map<String, String> getUserSettings() {
		return userSettings;
	}
	public void setUserSettings(Map<String, String> userSettings) {
		this.userSettings = userSettings;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userSettings == null) ? 0 : userSettings.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MongoUserDTO other = (MongoUserDTO) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userSettings == null) {
			if (other.userSettings != null)
				return false;
		} else if (!userSettings.equals(other.userSettings))
			return false;
		return true;
	}
	public MongoUserDTO(String userId, String name, Date creationDate, Map<String, String> userSettings) {
		super();
		this.userId = userId;
		this.name = name;
		this.creationDate = creationDate;
		this.userSettings = userSettings;
	}
	public MongoUserDTO() {
		
	}

	// Simple constructor for testing
	public MongoUserDTO(String userId, String email, String name) {
		this.userId = userId;
		this.name = name;
		// Note: email field doesn't exist in this DTO, using name for both
	}
	@Override
	public String toString() {
		return "MongoUserDTO [userId=" + userId + ", name=" + name + ", creationDate=" + creationDate
				+ ", userSettings=" + userSettings + "]";
	}
	
	
}
