package com.project.demo.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "City_Master")
public class CityMaster {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int population;
    
    @OneToOne(mappedBy="city")
    private CityMayor cityMayor;
    
    public CityMaster(Long id, String name, int population, CityMayor cityMayor) {
		super();
		this.id = id;
		this.name = name;
		this.population = population;
		this.cityMayor = cityMayor;
	}

	public CityMayor getCityMayor() {
		return cityMayor;
	}

	public void setCityMayor(CityMayor cityMayor) {
		this.cityMayor = cityMayor;
	}

	public CityMaster() {
    }

    public CityMaster(Long id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

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
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + this.population;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CityMaster other = (CityMaster) obj;
        if (this.population != other.population) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
    @Override
	public String toString() {
		return "CityMaster [id=" + id + ", name=" + name + ", population=" + population + ", cityMayor=" + cityMayor
				+ "]";
	}
}