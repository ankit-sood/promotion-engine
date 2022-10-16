package com.engine.promotion.model;

import java.util.Map;

public class Cart {
	private Map<String, Integer> productMap;

	public Map<String, Integer> getProductMap() {
		return productMap;
	}

	public void setProductMap(Map<String, Integer> productMap) {
		this.productMap = productMap;
	}
}
