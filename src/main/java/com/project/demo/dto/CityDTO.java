package com.project.demo.dto;

public class CityDTO {

	private Long id;
	private String name;
	private int population;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "CityDTO [id=" + id + ", name=" + name + ", population=" + population + "]";
	}

	public CityDTO() {
		super();
	}

	public CityDTO(Long id, String name, int population) {
		super();
		this.id = id;
		this.name = name;
		this.population = population;
	}

}
