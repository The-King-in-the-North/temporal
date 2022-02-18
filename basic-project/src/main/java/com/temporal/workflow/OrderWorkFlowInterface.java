package com.temporal.workflow;

import com.temporal.model.Order;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface OrderWorkFlowInterface {
	
	@WorkflowMethod
	public Order getOrderDetails(String id);

}
