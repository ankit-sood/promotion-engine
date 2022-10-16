package com.engine.promotion.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engine.promotion.model.PromotionRule;

import lombok.AllArgsConstructor;

@Service("comboPriceRule")
@AllArgsConstructor
public class ComboPriceRuleImpl implements Promotion{
	@Autowired
	private final PriceService priceService;

	@Override
	public double getOfferPrice(String skuId, PromotionRule rule, Map<String, Integer> productMap) {
		double price = 0.0;
		int offerQty = getOfferQty(skuId, rule.getDependentSkuId(), productMap);
		price = rule.getOfferPrice() * (double)offerQty;
		
		if(productMap.get(skuId) - offerQty > 0 ) {
			price = price + (productMap.get(skuId) - offerQty) * priceService.getUnitPrice(skuId);
		} else {
			price = price + (productMap.get(rule.getDependentSkuId()) - offerQty) * 
					priceService.getUnitPrice(rule.getDependentSkuId());
		}
		return price;
	}
	
	private int getOfferQty(String skuId, String dependentSkuId, Map<String, Integer> productMap) {
		int prodQty = productMap.getOrDefault(skuId, 0);
		int dependentProdQty = productMap.getOrDefault(dependentSkuId, 0);
		
		return prodQty > dependentProdQty ? dependentProdQty : prodQty;
	}

}
