package com.engine.promotion.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engine.promotion.service.Promotion;

import lombok.AllArgsConstructor;

@Service("defaultPromotionRule")
@AllArgsConstructor
public class DefaultPromotionImpl implements Promotion{
	@Autowired
	private final PriceService priceService;

	@Override
	public double getOfferPrice(String skuId, PromotionRule rule, Map<String, Integer> productMap) {
		return priceService.getUnitPrice(skuId) * productMap.getOrDefault(skuId, 0);
	}
}
