package com.project.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.MayorMaster;

@Repository
public interface MayorRepository extends JpaRepository<MayorMaster, Long> {

	@Query("Select m from MayorMaster m where m.name = ?1")
	public MayorMaster findMayorbyName(String mayorName);
	
	@Query("Select m.name, m.age from MayorMaster m")
	public List<Object> findMayorNames();
}
