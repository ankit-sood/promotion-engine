package com.engine.promotion.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.engine.promotion.model.Cart;
import com.engine.promotion.model.PromotionRule;

@Service
public class PriceCalculationService {
	@Autowired
	@Qualifier("comboPriceRule")
	private Promotion comboPriceRule;
	
	@Autowired
	@Qualifier("discountPercentRule")
	private Promotion discountPercentRule;
	
	@Autowired
	@Qualifier("discountPriceRule")
	private Promotion discountPriceRule;
	
	@Autowired
	@Qualifier("defaultPromotionRule")
	private Promotion defaultPromotionRule;
	
	@Autowired
	private PromotionRuleService promotionRuleService;
	
	public double getTotalPrice(Cart cart) {
		Map<String, Integer> products = cart.getProductMap();
		double finalPrice = 0.0;
		Set<String> processed = new HashSet<>();
		for(String key: products.keySet()) {
			if(!processed.contains(key)) {
				PromotionRule rule = promotionRuleService.getPromotionRule(key);
				String offerType = rule != null ? rule.getOfferType() : null;
				finalPrice += getPromotionImpl(offerType).getOfferPrice(key, rule, products);
				processed.add(key);
				if(rule!=null && rule.getDependentSkuId()!=null) {
					processed.add(rule.getDependentSkuId());
				}
			}
		}
		return finalPrice;
	}
	
	private Promotion getPromotionImpl(String offerType) {
		Promotion promotion = null;
		if("COMBO_PRICE".equals(offerType)) {
			promotion = comboPriceRule;
		} else if("DISC_PRICE".equals(offerType)) {
			promotion = discountPriceRule;
		} else if("DISC_PERCENT".equals(offerType)) {
			promotion = discountPercentRule;
		} else {
			promotion = defaultPromotionRule;
		}
		return promotion;
	}
}
