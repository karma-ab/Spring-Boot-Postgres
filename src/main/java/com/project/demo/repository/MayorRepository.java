package com.project.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.MayorMaster;

@Repository
public interface MayorRepository extends PagingAndSortingRepository<MayorMaster, Long> {

}
