package com.customer.app.util;

import java.security.SecureRandom;

public class GenerateSecureOTP {
	
	
	public static int generateOTP() {
		SecureRandom random=new SecureRandom();
		return random.nextInt(999)+1000;
	}

}
