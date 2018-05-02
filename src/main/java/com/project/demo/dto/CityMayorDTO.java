package com.project.demo.dto;

public class CityMayorDTO {

	private long cityId;
	private long mayorId;

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public long getMayorId() {
		return mayorId;
	}

	public void setMayorId(long mayorId) {
		this.mayorId = mayorId;
	}

	@Override
	public String toString() {
		return "CityMayorDTO [cityId=" + cityId + ", mayorId=" + mayorId + "]";
	}

	public CityMayorDTO(long cityId, long mayorId) {
		super();
		this.cityId = cityId;
		this.mayorId = mayorId;
	}

	public CityMayorDTO() {
	}

}
