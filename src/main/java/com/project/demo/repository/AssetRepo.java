package com.project.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.project.demo.entity.AssetInventory;

public interface AssetRepo extends PagingAndSortingRepository<AssetInventory, Long> {

	
}
