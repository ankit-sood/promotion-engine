package com.engine.promotion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.engine.promotion.model.Cart;
import com.engine.promotion.service.PriceCalculationService;

@SpringBootTest
class PromotionEngineApplicationTests {
	@Autowired
	private PriceCalculationService priceCalculationService;
	
	@Test
	void success_usecase1() {
		Cart cart = new Cart();
		Map<String, Integer> productMap = new HashMap<>();
		productMap.put("A", 5);
		productMap.put("B", 5);
		productMap.put("C", 1);
		cart.setProductMap(productMap);
		double actualPrice = priceCalculationService.getTotalPrice(cart);
		assertEquals(370.0, actualPrice);
	}
	
	@Test
	void success_usecase2() {
		Cart cart = new Cart();
		Map<String, Integer> productMap = new HashMap<>();
		productMap.put("A", 1);
		productMap.put("B", 1);
		productMap.put("C", 1);
		cart.setProductMap(productMap);
		double actualPrice = priceCalculationService.getTotalPrice(cart);
		assertEquals(100.0, actualPrice);
	}
	
	@Test
	void success_usecase3() {
		Cart cart = new Cart();
		Map<String, Integer> productMap = new HashMap<>();
		productMap.put("A", 3);
		productMap.put("B", 5);
		productMap.put("C", 1);
		productMap.put("D", 1);
		cart.setProductMap(productMap);
		double actualPrice = priceCalculationService.getTotalPrice(cart);
		assertEquals(280.0, actualPrice);
	}

}
