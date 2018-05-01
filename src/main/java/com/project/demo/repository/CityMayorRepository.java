package com.project.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.CityMayor;

@Repository
public interface CityMayorRepository extends PagingAndSortingRepository<CityMayor,Long> {

}
