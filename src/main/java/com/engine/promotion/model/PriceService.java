package com.engine.promotion.model;

import java.util.HashMap;
import java.util.Map;

public class PriceService {
	private Map<String, Integer> priceMap;
	
	public PriceService() {
		priceMap = new HashMap<>();
		priceMap.put("A", 50);
		priceMap.put("B", 30);
		priceMap.put("C", 20);
		priceMap.put("D", 15);
	}
	
	public Integer getUnitPrice(Integer skuId) {
		return priceMap.getOrDefault(skuId, null);
	}
}
