package com.temporal.workflow;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;

import com.temporal.activity.OrderActivityInterface;
import com.temporal.model.Order;
import com.temporal.repo.OrderConfig;

import io.temporal.activity.Activity;
import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;

public class OrderWorkFlow implements OrderWorkFlowInterface{

	private boolean isPaymentDetailsFetched = false;
	
	private final RetryOptions retryoptions = RetryOptions.newBuilder().setInitialInterval(Duration.ofSeconds(1))
			.setMaximumInterval(Duration.ofSeconds(100)).setBackoffCoefficient(2).setMaximumAttempts(50000).build();
	private final ActivityOptions options = ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(30))
			.setRetryOptions(retryoptions).build();

	private final OrderActivityInterface orderActivityInterface = Workflow.newActivityStub(OrderActivityInterface.class, options);
	
	
	
	OrderConfig orderConfig = new OrderConfig();
	
	@Override
	public Order getOrderDetails(String id) {
		orderActivityInterface.startWorkflow();
		
		String paymentDetails = orderActivityInterface.getPaymentDetails(id);
		if(paymentDetails != "") {
			isPaymentDetailsFetched = true;
		}
		Workflow.await(() -> isPaymentDetailsFetched);
		Order orderInfo = orderConfig.orderVal(id);
		if(orderInfo !=null) {
			orderInfo.setPaymentDetails(paymentDetails);
		}
		
		return orderInfo;
	}

}
