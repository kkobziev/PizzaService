package com.epam.pizzaservice.domain.DTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pizzaservice.domain.Order;
import com.epam.pizzaservice.domain.Pizza;
import com.epam.pizzaservice.service.CustomerService;
import com.epam.pizzaservice.service.PizzaService;

@Component
public class OrderDTO {
	private Long id;
	private String name;
	private Long customer;
	private Map<String, Integer> pizzaMap = new HashMap<>();
	
	private CustomerService customerService;
	private PizzaService pizzaService;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCustomer() {
		return customer;
	}

	public void setCustomer(Long customer) {
		this.customer = customer;
	}

	public Map<String, Integer> getPizzaMap() {
		return pizzaMap;
	}

	public void setPizzaMap(Map<String, Integer> pizzaMap) {
		this.pizzaMap = pizzaMap;
	}	
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setPizzaService(PizzaService pizzaService) {
		this.pizzaService = pizzaService;
	}
	
	public OrderDTO(){}
	
	public Order createNewOrder(){
		Order order = new Order();
		if (id != null) { order.setId(id); }
		order.setName(name);
		order.setCustomer(customerService.getCustomerById(customer));
		
		Map<Pizza, Integer> pizzas = new HashMap<>();
		
		if (pizzaMap != null) {
			for (Entry entry : pizzaMap.entrySet()) {
				pizzas.put(pizzaService.getPizzaByID(Long.parseLong((String)entry.getKey())), (Integer) entry.getValue());
			}
		}
		order.setPizzaMap(pizzas);
		
		return order; 
	}	
}
