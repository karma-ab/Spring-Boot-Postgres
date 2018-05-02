package com.project.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Mayor_Master")
public class MayorMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long mayorId;

	@Column(name = "Name")
	private String name;

	@Column(name = "Age")
	private int age;

	@OneToOne(mappedBy = "mayor")
	private CityMayor cityMayor;

	public MayorMaster() {
	}

	public MayorMaster(Long mayorId, String name, int age, CityMayor cityMayor) {
		super();
		this.mayorId = mayorId;
		this.name = name;
		this.age = age;
		this.cityMayor = cityMayor;
	}

	public Long getMayorId() {
		return mayorId;
	}

	public void setMayorId(Long mayorId) {
		this.mayorId = mayorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public CityMayor getCityMayor() {
		return cityMayor;
	}

	public void setCityMayor(CityMayor cityMayor) {
		this.cityMayor = cityMayor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((cityMayor == null) ? 0 : cityMayor.hashCode());
		result = prime * result + ((mayorId == null) ? 0 : mayorId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		MayorMaster other = (MayorMaster) obj;
		if (age != other.age)
			return false;
		if (cityMayor == null) {
			if (other.cityMayor != null)
				return false;
		} else if (!cityMayor.equals(other.cityMayor))
			return false;
		if (mayorId == null) {
			if (other.mayorId != null)
				return false;
		} else if (!mayorId.equals(other.mayorId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
