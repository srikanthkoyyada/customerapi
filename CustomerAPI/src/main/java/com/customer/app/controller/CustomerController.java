package com.customer.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.app.dto.AccountDTO;
import com.customer.app.dto.CustomerRequestDTO;
import com.customer.app.dto.CustomerResponseDTO;
import com.customer.app.dto.PayeeDTO;
import com.customer.app.service.AccountService;
import com.customer.app.service.CustomerService;
import com.customer.app.service.PayeeService;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private PayeeService payeeService;

	@RequestMapping(path = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<CustomerResponseDTO> authenticateCustomerLogin(@RequestBody CustomerRequestDTO request) {
		CustomerResponseDTO response = new CustomerResponseDTO();
		if (customerService.authenticateCustomer(request)) {
			response.setStatus("success");
			response.setMessage("authentication success");
			return new ResponseEntity<CustomerResponseDTO>(response, HttpStatus.OK);
		} else {
			response.setStatus("failure");
			response.setMessage("authentication failed");
			return new ResponseEntity<CustomerResponseDTO>(response, HttpStatus.FORBIDDEN);
		}

	}

	// Assuming that user logged in and this is an internal call after getting the
	// customer detail
	@RequestMapping(path = "/dashboard", method = RequestMethod.GET)
	public ResponseEntity<CustomerResponseDTO> getDashboardDetails(@RequestParam Long customerId) {
		AccountDTO accountDTO = accountService.getCustomerDashBoardDetials(customerId);
		CustomerResponseDTO response = new CustomerResponseDTO();
		if (accountDTO != null) {
			response.setStatus("success");
			response.setAccountDTO(accountDTO);
		} else {
			response.setStatus("failure");
			response.setMessage("Invalid customer");
		}
		return new ResponseEntity<CustomerResponseDTO>(response, HttpStatus.OK);
	}

	// Assuming customer logged in and details(other than customer entered like
	// customer account number etc)
	// are available for the API input
	@RequestMapping(path = "/payeeRegister", method = RequestMethod.POST)
	public ResponseEntity<Object> registerPayee(@Valid @RequestBody PayeeDTO request) {
		CustomerResponseDTO response = new CustomerResponseDTO();

		int otp = payeeService.registerPayee(request);
		if (otp != 0) {
			response.setStatus("success");
			response.setMessage("Payee Registered");
			response.setOtp(otp);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setStatus("failure");
			response.setMessage("Payee Registration Failed");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(path = "/verifyPayee", method = RequestMethod.PUT)
	public ResponseEntity<CustomerResponseDTO> updateRegisteredPayee(@RequestBody PayeeDTO request) {
		CustomerResponseDTO response = new CustomerResponseDTO();
		boolean isPayeeRegistered = true;
		if (isPayeeRegistered) {
			response.setStatus("success");
			response.setMessage("Payee Registered");
			return new ResponseEntity<CustomerResponseDTO>(response, HttpStatus.OK);
		} else {
			response.setStatus("failure");
			response.setMessage("Payee Registration Failed");
			return new ResponseEntity<CustomerResponseDTO>(response, HttpStatus.BAD_REQUEST);
		}

	}

}
