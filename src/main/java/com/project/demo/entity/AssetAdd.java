package com.project.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AssetAdd {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String assetName;
	
	private long assetPrice;
	
	private String eligibility;
	
	private String ratioCheck;
	
	private String capCheck;
	
	private String action;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public long getAssetPrice() {
		return assetPrice;
	}

	public void setAssetPrice(long assetPrice) {
		this.assetPrice = assetPrice;
	}

	public String getEligibility() {
		return eligibility;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

	public String getRatioCheck() {
		return ratioCheck;
	}

	public void setRatioCheck(String ratioCheck) {
		this.ratioCheck = ratioCheck;
	}

	public String getCapCheck() {
		return capCheck;
	}

	public void setCapCheck(String capCheck) {
		this.capCheck = capCheck;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((assetName == null) ? 0 : assetName.hashCode());
		result = prime * result + (int) (assetPrice ^ (assetPrice >>> 32));
		result = prime * result + ((capCheck == null) ? 0 : capCheck.hashCode());
		result = prime * result + ((eligibility == null) ? 0 : eligibility.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ratioCheck == null) ? 0 : ratioCheck.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssetAdd other = (AssetAdd) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (assetName == null) {
			if (other.assetName != null)
				return false;
		} else if (!assetName.equals(other.assetName))
			return false;
		if (assetPrice != other.assetPrice)
			return false;
		if (capCheck == null) {
			if (other.capCheck != null)
				return false;
		} else if (!capCheck.equals(other.capCheck))
			return false;
		if (eligibility == null) {
			if (other.eligibility != null)
				return false;
		} else if (!eligibility.equals(other.eligibility))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ratioCheck == null) {
			if (other.ratioCheck != null)
				return false;
		} else if (!ratioCheck.equals(other.ratioCheck))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssetAdd [id=" + id + ", assetName=" + assetName + ", assetPrice=" + assetPrice + ", eligibility="
				+ eligibility + ", ratioCheck=" + ratioCheck + ", capCheck=" + capCheck + ", action=" + action + "]";
	}

	public AssetAdd(Long id, String assetName, long assetPrice, String eligibility, String ratioCheck, String capCheck,
			String action) {
		super();
		this.id = id;
		this.assetName = assetName;
		this.assetPrice = assetPrice;
		this.eligibility = eligibility;
		this.ratioCheck = ratioCheck;
		this.capCheck = capCheck;
		this.action = action;
	}

	public AssetAdd() {
		
	}
	
	
}
