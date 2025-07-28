package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.AssetAdd;

@Repository
public interface AssetAddRepo extends JpaRepository<AssetAdd, Long> {

}
