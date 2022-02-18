package com.temporal.basicService;

import org.springframework.stereotype.Service;

import com.temporal.model.Order;
import com.temporal.workflow.OrderWorkFlowInterface;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowClientOptions;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;

@Service
public class BasicService implements BasicServiceInterface {
	private String temporalServiceAddress = "127.0.0.1:7233";

	private String temporalNamespace = "default";

	public Order getOrderDetails(String id) {
		WorkflowServiceStubs service = WorkflowServiceStubs.newInstance(WorkflowServiceStubsOptions.newBuilder().setTarget(temporalServiceAddress).build());
        WorkflowClient client = WorkflowClient.newInstance(service, WorkflowClientOptions.newBuilder().setNamespace(temporalNamespace).build());
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(Shared.ORDER_TASK_Q)
                .build();
        
        OrderWorkFlowInterface workflow = client.newWorkflowStub(OrderWorkFlowInterface.class, options);
       
        Order orderDetails = workflow.getOrderDetails(id);
        return orderDetails;
		
	}
	
	
}
