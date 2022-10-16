package com.engine.promotion.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.engine.promotion.service.Promotion;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DiscountPriceRuleImpl implements Promotion{
	@Autowired
	private PriceService priceService;

	@Override
	public double getOfferPrice(String skuId, PromotionRule rule, Map<String, Integer> productMap) {
		double price = 0.0;
		int orderedQty = productMap.get(skuId);
		int count = orderedQty/rule.getMinQty();
		price = (rule.getOfferPrice() * count) + 
				(orderedQty - (count * rule.getMinQty()) * priceService.getUnitPrice(skuId));
		return price;
	}

}
