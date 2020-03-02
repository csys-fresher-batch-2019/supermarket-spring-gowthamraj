package com.chainsys.supermarketapp.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import citipe.servicelayer.UserService;

public class WalletAPI {

	private static final Long COMPANY_MOBILE_NO = 6789012340L; // use your registered wallet mobileno
	 private static final Logger logger = LoggerFactory.getLogger(WalletAPI.class);
	public static boolean pay(Long mobileNo, int pin, int amount) {

		boolean status = false;
		
		 try {
		// UserService userService = new UserService(); status =
		 //userService.walletTransfer(mobileNo, COMPANY_MOBILE_NO, pin, amount);
		 System.out.println(status); }
		 catch (Exception e) 
		 {
			logger.debug(e.getMessage());
		 status = false; }
		
		return status;
	}

}
