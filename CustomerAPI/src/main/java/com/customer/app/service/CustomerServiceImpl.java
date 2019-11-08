package com.customer.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.customer.app.dto.CustomerRequestDTO;
import com.customer.app.entity.Customer;
import com.customer.app.repository.CustomerRepositoy;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepositoy customerRepository;

	@Override
	public boolean authenticateCustomer(CustomerRequestDTO request) {
		Optional<Customer> customer = customerRepository.findByUsername(request.getUsername());

		if (customer.isPresent()) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
			if (encoder.matches(request.getPassword(), customer.get().getPassword()))
				return true;
			else
				return false;
		}
		return false;
	}

}
