package com.engine.promotion.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.engine.promotion.service.Promotion;

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
	
	public double getTotalPrice(Cart cart) {
		return 0;
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
