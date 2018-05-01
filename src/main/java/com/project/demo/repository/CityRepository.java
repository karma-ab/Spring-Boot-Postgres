package com.project.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.CityMaster;


@Repository
public interface CityRepository extends PagingAndSortingRepository<CityMaster, Long> {

	@Query("Select c from CityMaster c Where c.name = ?1")
	public CityMaster getCityFromName(String cityName);
}
