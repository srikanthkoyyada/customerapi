package com.customer.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.customer.app.dto.PayeeDTO;
import com.customer.app.entity.Account;
import com.customer.app.entity.OTPStore;
import com.customer.app.entity.Payee;
import com.customer.app.repository.AccountRepositoy;
import com.customer.app.repository.OTPStoreRepository;
import com.customer.app.repository.PayeeRepository;
import com.customer.app.util.GenerateSecureOTP;

@Service
public class PayeeServiceImpl implements PayeeService {

	@Autowired
	private PayeeRepository payeeRepository;
	
	@Autowired
	private AccountRepositoy accountRepository;
	
	@Autowired
	private OTPStoreRepository otpStoreRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Value(value="PAYEE_REG")
	private String otpFor;

	@Transactional
	@Override
	public int registerPayee(PayeeDTO payeeDTO) {

		Payee payee = new Payee();
		modelMapper.map(payeeDTO, payee);
		Payee savedPayee = payeeRepository.save(payee);
		if (savedPayee.getPayeeId() != null) {
			Optional<Account> account=accountRepository.findById(payeeDTO.getAccountNumber());
			OTPStore savedOTP=null;
			if(account.isPresent()) {
				OTPStore otpStore=new OTPStore();
				otpStore.setOtp(GenerateSecureOTP.generateOTP());
				otpStore.setCustomerId(account.get().getCustomerId());
				otpStore.setOtpFor(otpFor);
				savedOTP=otpStoreRepository.save(otpStore);
			}
			return ((savedOTP.getId())!=null?savedOTP.getOtp():0);
		}
		return 0;
	}

}
