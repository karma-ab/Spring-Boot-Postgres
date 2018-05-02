package com.project.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CityMayorData")
public class CityMayor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cityMayorId;

	@OneToOne
	@JoinColumn(unique = true, nullable = false)
	@NotNull
	private CityMaster city;

	@OneToOne
	@JoinColumn(unique = true, nullable = false)
	private MayorMaster mayor;

	public Long getCityMayorId() {
		return cityMayorId;
	}

	public void setCityMayorId(Long cityMayorId) {
		this.cityMayorId = cityMayorId;
	}

	public CityMaster getCity() {
		return city;
	}

	public void setCity(CityMaster city) {
		this.city = city;
	}

	public MayorMaster getMayor() {
		return mayor;
	}

	public void setMayor(MayorMaster mayor) {
		this.mayor = mayor;
	}

	@Override
	public String toString() {
		return "CityMayor [cityMayorId=" + cityMayorId + ", city=" + city + ", mayor=" + mayor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((cityMayorId == null) ? 0 : cityMayorId.hashCode());
		result = prime * result + ((mayor == null) ? 0 : mayor.hashCode());
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
		CityMayor other = (CityMayor) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (cityMayorId == null) {
			if (other.cityMayorId != null)
				return false;
		} else if (!cityMayorId.equals(other.cityMayorId))
			return false;
		if (mayor == null) {
			if (other.mayor != null)
				return false;
		} else if (!mayor.equals(other.mayor))
			return false;
		return true;
	}

	public CityMayor(CityMaster city, MayorMaster mayor) {
		super();
		this.city = city;
		this.mayor = mayor;
	}

	public CityMayor() {

	}

}
