package com.temporal.activity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.temporal.paymentProxy.PaymentProxy;


@Component
public class OrderActivityImpl implements OrderActivityInterface {

	
	@Autowired
	private PaymentProxy paymentProxy;
	
	@Override
	public String getPaymentDetails(String id) {
		String paymentDetails = paymentProxy.getPaymentDetails(id);
		return paymentDetails;
	}

	@Override
	public void startWorkflow() {
		System.out.println("@bhay says workflow has started !");
		
	}
	

}
