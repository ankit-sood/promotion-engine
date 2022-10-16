package com.engine.promotion.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PriceService {
	private Map<String, Double> priceMap;
	
	public PriceService() {
		priceMap = new HashMap<>();
		priceMap.put("A", 50.0);
		priceMap.put("B", 30.0);
		priceMap.put("C", 20.0);
		priceMap.put("D", 15.0);
	}
	
	public Double getUnitPrice(String skuId) {
		return priceMap.getOrDefault(skuId, 0.0);
	}
}
