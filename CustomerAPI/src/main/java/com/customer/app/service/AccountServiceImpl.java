package com.customer.app.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.app.dto.AccountDTO;
import com.customer.app.entity.Account;
import com.customer.app.repository.AccountRepositoy;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepositoy accountRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AccountDTO getCustomerDashBoardDetials(Long customerId) {
		Optional<Account> account = accountRepository.findByCustomerId(customerId);
		if (account.isPresent()) {
			AccountDTO accountDTO = new AccountDTO();
			modelMapper.map(account.get(), accountDTO);
			return accountDTO;
		}
		return null;
	}

}
