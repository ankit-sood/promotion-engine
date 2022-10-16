package com.engine.promotion.model;

public class PromotionRule {
	private String skuId;
	
	private String offerType;
	
	private int minQty;
	
	private double offerPrice;

	private String dependentSkuId;
	
	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	public String getOfferType() {
		return offerType;
	}
	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}
	public int getMinQty() {
		return minQty;
	}
	public void setMinQty(int minQty) {
		this.minQty = minQty;
	}
	public double getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(double offerPrice) {
		this.offerPrice = offerPrice;
	}
	public String getDependentSkuId() {
		return dependentSkuId;
	}
	public void setDependentSkuId(String dependentSkuId) {
		this.dependentSkuId = dependentSkuId;
	}
}
