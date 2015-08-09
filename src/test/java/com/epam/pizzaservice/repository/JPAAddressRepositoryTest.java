package com.epam.pizzaservice.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.pizzaservice.domain.Address;
import com.epam.pizzaservice.repository.templetes.ITRepositoryTestsTemplete;

public class JPAAddressRepositoryTest extends ITRepositoryTestsTemplete{
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Test
	public void AddressRepository_testSaveMethod_NormalWork(){
		Address address = new Address();
		address.setCountry("Ukraine");
		
		Long id = addressRepository.save(address);
		System.out.println(id);
		assertNotNull(id);
		
	}
	
	@Test
	public void AddressRepository_testGetAddressById_NormalWork(){
		Address address = addressRepository.getAddressById(1L);
		
		Long id = address.getId();
		System.out.println(id);
		assertNotNull(id);
		
	}

}