package com.engine.promotion.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.engine.promotion.model.PromotionRule;

@ExtendWith(MockitoExtension.class)
public class DiscountPriceRuleImplTest {
	private Promotion promotion;
	private PriceService priceService;
	
	@BeforeEach
	void setUp() {
		priceService = Mockito.mock(PriceService.class);
		this.promotion = new DiscountPriceRuleImpl(priceService);
	}
	
	@Test
	void getOfferPriceTest() {
		Map<String, Integer> productMap = new HashMap<>();
		productMap.put("A", 10);
		
		PromotionRule rule = new PromotionRule();
		rule.setSkuId("A");
		rule.setOfferPrice(130.0);
		rule.setMinQty(3);
		
		Mockito.when(priceService.getUnitPrice("A")).thenReturn(50.0);
		double actualPrice = promotion.getOfferPrice("A", rule, productMap);
		assertEquals(440.0, actualPrice);
	}
}
