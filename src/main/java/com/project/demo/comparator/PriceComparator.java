package com.project.demo.comparator;

import java.util.Comparator;

import com.project.demo.entity.AssetInventory;

public class PriceComparator implements Comparator<AssetInventory> {

	@Override
	public int compare(AssetInventory o1, AssetInventory o2) {
		
		int result = (o1.getAssetPrice()<o2.getAssetPrice())?1:-1;
		return (o1.getAssetPrice()==o2.getAssetPrice()) ? 0 : result;
	}
	
	

}
