package com.epam.pizzaservice.web;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.epam.pizzaservice.domain.Order;
import com.epam.pizzaservice.domain.Pizza;
import com.epam.pizzaservice.exception.OrderNotFoundException;
import com.epam.pizzaservice.exception.PizzaNotFoundException;
import com.epam.pizzaservice.service.CustomerService;
import com.epam.pizzaservice.service.OrderService;
import com.epam.pizzaservice.service.PizzaService;

abstract class AbstractBinder {
	@Autowired
	protected PizzaService pizzaService;
	
	@Autowired 
	protected OrderService orderService;
	
	@Autowired
	protected CustomerService customerService;
	
	private Pizza getPizzaById(Long id){
		if (id <= 0) throw new IllegalArgumentException("ID<=0");
		System.out.println("pizza id =" + id);
		Pizza pizza = pizzaService.getPizzaByID(id);
		if (pizza == null) throw new PizzaNotFoundException("Pizza id = " + id + " not found");
		return pizza;
	}
	
	private Order getOrderById(Long id){
		if (id <= 0) throw new IllegalArgumentException("ID<=0");
		Order order = orderService.getOrderByID(id);
		if (order == null) throw new OrderNotFoundException("Order id = " + id + " not found");
		return order;
	}
	
	@InitBinder
	private void pizzaBinder(WebDataBinder binder){
		binder.registerCustomEditor(Pizza.class, new PropertyEditorSupport(){
			@Override
			public void setAsText(String pizzaId){
				Pizza pizza = null;
				if (pizzaId!=null && !pizzaId.trim().isEmpty()){
					Long id = Long.parseLong(pizzaId);
					pizza = getPizzaById(id);
				}
				setValue(pizza);
			}
		});
	}
	
	@InitBinder
	private void orderBinder(WebDataBinder binder){
		binder.registerCustomEditor(Order.class, new PropertyEditorSupport(){
			@Override
			public void setAsText(String orderId){
				Order order = null;
				if (orderId!=null && !orderId.trim().isEmpty()){
					Long id = Long.parseLong(orderId);
					order = getOrderById(id);
				}
				setValue(order);
			}
		});
	}

}
