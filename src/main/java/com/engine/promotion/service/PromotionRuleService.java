package com.engine.promotion.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.engine.promotion.model.PromotionRule;

@Service
public class PromotionRuleService {
	private Map<String, List<PromotionRule>> promotionRulesMap;
	
	public PromotionRuleService() {
		promotionRulesMap = new HashMap<>();
		List<PromotionRule> rules = new ArrayList<>();
		rules.add(getDiscountPriceRule("A", 3, 130.0));
		rules.add(getComboPriceRule("A", 30.0, "D"));
		promotionRulesMap.put("A", rules);
		
		rules = new ArrayList<>();
		rules.add(getComboPriceRule("D", 30.0, "A"));
		promotionRulesMap.put("D", rules);
		
		rules = new ArrayList<>();
		rules.add(getDiscountPriceRule("B", 2, 45.0));
		promotionRulesMap.put("B", rules);
		
	}
	
	public PromotionRule getPromotionRule(String skuId) {
		List<PromotionRule> rules = promotionRulesMap.getOrDefault(skuId, new ArrayList<>());
		return rules.size() != 0 ? rules.get(0) : null;
	}
	
//	private PromotionRule getDiscountPercentRule() {
//		PromotionRule promotionRule = new PromotionRule();
//		promotionRule.setSkuId("");
//		promotionRule.setMinQty(minQty);
//		promotionRule.setOfferPrice(offerPrice);
//		promotionRule.setOfferType("");
//		promotionRule.setDependentSkuId(dependentSkuId);
//		return promotionRule;
//	}
	
	private PromotionRule getDiscountPriceRule(String skuId, int minQty, double offerPrice) {
		PromotionRule promotionRule = new PromotionRule();
		promotionRule.setSkuId(skuId);
		promotionRule.setMinQty(minQty);
		promotionRule.setOfferPrice(offerPrice);
		promotionRule.setOfferType("DISC_PRICE");
		return promotionRule;
	}
	
	private PromotionRule getComboPriceRule(String skuId, double offerPrice, String dependentSkuId) {
		PromotionRule promotionRule = new PromotionRule();
		promotionRule.setSkuId(skuId);
		promotionRule.setOfferPrice(offerPrice);
		promotionRule.setOfferType("COMBO_PRICE");
		promotionRule.setDependentSkuId(dependentSkuId);
		return promotionRule;
	}
}
