package com.engine.promotion.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.engine.promotion.service.Promotion;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DiscountPercentRuleImpl implements Promotion{
	@Autowired
	private PriceService priceService;

	@Override
	public double getOfferPrice(String skuId, PromotionRule rule, Map<String, Integer> productMap) {
		double price = 0.0;
		int orderedQty = productMap.get(skuId);
		price = orderedQty  * priceService.getUnitPrice(skuId) * (1 - rule.getOfferPrice());
		return price;
	}

}
