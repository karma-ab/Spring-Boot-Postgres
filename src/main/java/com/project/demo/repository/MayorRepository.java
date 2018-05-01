package com.project.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.MayorMaster;

@Repository
public interface MayorRepository extends PagingAndSortingRepository<MayorMaster, Long> {

	@Query("Select m from MayorMaster m where m.name = ?1")
	public MayorMaster findMayorbyName(String mayorName);
}
