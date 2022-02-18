package com.temporal.basicproject;

import com.temporal.activity.OrderActivityImpl;
import com.temporal.basicService.Shared;
import com.temporal.workflow.OrderWorkFlow;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class WorkerMainApplication {
	
	public static void main (String[] args) {
		  // This gRPC stubs wrapper talks to the local docker instance of the Temporal service.
        WorkflowServiceStubs service = WorkflowServiceStubs.newInstance();
        WorkflowClient client = WorkflowClient.newInstance(service);
        // Create a Worker factory that can be used to create Workers that poll specific Task Queues.
        WorkerFactory factory = WorkerFactory.newInstance(client);
        Worker worker = factory.newWorker(Shared.ORDER_TASK_Q);
        // This Worker hosts both Workflow and Activity implementations.
        // Workflows are stateful, so you need to supply a type to create instances.
        worker.registerWorkflowImplementationTypes(OrderWorkFlow.class);
        // Activities are stateless and thread safe, so a shared instance is used.
        worker.registerActivitiesImplementations(new OrderActivityImpl());
        // Start polling the Task Queue.
        factory.start();
	}

}
