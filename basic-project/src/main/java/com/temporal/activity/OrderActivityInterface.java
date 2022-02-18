package com.temporal.activity;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface OrderActivityInterface {

	@ActivityMethod
	public void startWorkflow();
	
	@ActivityMethod
	public String getPaymentDetails(String id);
	
}
