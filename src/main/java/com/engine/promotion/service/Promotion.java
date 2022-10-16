package com.engine.promotion.service;

import java.util.Map;

import com.engine.promotion.model.PromotionRule;

public interface Promotion {
	double getOfferPrice(String skuId, PromotionRule rule, Map<String, Integer> productMap);
}
