package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.CityEntity;

@Repository
public interface CityRepository extends PagingAndSortingRepository<CityEntity, Long> {

}
