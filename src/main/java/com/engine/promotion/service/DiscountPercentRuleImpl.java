package com.engine.promotion.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engine.promotion.model.PromotionRule;

import lombok.AllArgsConstructor;

@Service("discountPercentRule")
@AllArgsConstructor
public class DiscountPercentRuleImpl implements Promotion{
	@Autowired
	private final PriceService priceService;

	@Override
	public double getOfferPrice(String skuId, PromotionRule rule, Map<String, Integer> productMap) {
		double price = 0.0;
		int orderedQty = productMap.getOrDefault(skuId, 0);
		price = orderedQty  * priceService.getUnitPrice(skuId) * ((100 - rule.getOfferPrice())/100);
		return price;
	}

}
