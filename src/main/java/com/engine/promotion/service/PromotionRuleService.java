package com.engine.promotion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.engine.promotion.model.PromotionRule;

@Service
public class PromotionRuleService {
	private Map<String, List<PromotionRule>> promotionRulesMap;
	
	public PromotionRuleService() {

	}
	
	public PromotionRule getPromotionRule(String skuId) {
		List<PromotionRule> rules = promotionRulesMap.getOrDefault(skuId, new ArrayList<>());
		return rules.size() != 0 ? rules.get(0) : null;
	}
}
