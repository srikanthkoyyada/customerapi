package com.customer.app.service;

import com.customer.app.dto.CustomerRequestDTO;

public interface CustomerService {

	boolean authenticateCustomer(CustomerRequestDTO request);

}
