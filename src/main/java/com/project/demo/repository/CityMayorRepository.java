package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.CityMayor;

@Repository
public interface CityMayorRepository extends JpaRepository<CityMayor, Long> {

}
