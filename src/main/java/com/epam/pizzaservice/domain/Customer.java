package com.epam.pizzaservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class Customer {
	//@Id
	//@GeneratedValue
	private Integer id;
	private String name;
	private AccumulativeCard accumulativeCard;
	
	public Customer(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Customer() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public AccumulativeCard getAccumulativeCard() {
		return accumulativeCard;
	}
	public void setAccumulativeCard(AccumulativeCard accumulativeCard) {
		this.accumulativeCard = accumulativeCard;
	}

}
