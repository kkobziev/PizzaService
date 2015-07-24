package com.epam.pizzaservice.infostructure;

import java.util.HashMap;
import java.util.Map;

import com.epam.pizzaservice.repository.TestOrderRepository;
import com.epam.pizzaservice.repository.TestPizzaRepository;
import com.epam.pizzaservice.service.SimpleOrderService;

public class JavaConfig implements Config{
	private Map<String,Class<?>> map = new HashMap<>();
	
	{
		map.put("orderRepository", TestOrderRepository.class);
		map.put("pizzaRepository", TestPizzaRepository.class);
		map.put("orderService", SimpleOrderService.class);
	}

	@Override
	public Class<?> getImplementation(String beanName) {
		return map.get(beanName);
	}

}