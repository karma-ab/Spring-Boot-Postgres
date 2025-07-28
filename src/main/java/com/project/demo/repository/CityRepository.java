package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.CityMaster;

@Repository
public interface CityRepository extends JpaRepository<CityMaster, Long> {

	@Query("Select c from CityMaster c Where c.name = ?1")
	public CityMaster getCityFromName(String cityName);
}
