package com.project.demo.service;

import java.lang.reflect.Type;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.comparator.PriceComparator;
import com.project.demo.dto.AssetDTO;

import com.project.demo.entity.AssetInventory;
import com.project.demo.repository.AssetAddRepo;
import com.project.demo.repository.AssetRepo;
import com.project.demo.service.interfaces.IAssetService;


@Service
public class AssetService implements IAssetService {

	@Autowired
	AssetRepo assetRepo;

	@Autowired
	AssetAddRepo assetAddRepo;

	@Override
	public List<AssetDTO> sortAsset() {

		List<AssetInventory> assetList = (List<AssetInventory>) assetRepo.findAll();

		Collections.sort(assetList, new PriceComparator());

		AtomicInteger counter = new AtomicInteger(0);
		assetList.forEach(asset -> {
			if (counter.get() != 2) {

				if (("Eligible in Primary").equals(asset.getEligibility())) {
					asset.setAction("Confirm in Primary");
					counter.getAndAdd(1);
				}

			}
			else{
				asset.setAction("Confirmed in Secondary");
				asset.setEligibility("Moved to Secondary");
			}
		});
		
		assetList = (List<AssetInventory>) assetRepo.saveAll(assetList);
	
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<AssetDTO>>() {}.getType();
		return mapper.map(assetList, listType);
	}

}
