package com.engine.promotion.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engine.promotion.model.PromotionRule;

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
