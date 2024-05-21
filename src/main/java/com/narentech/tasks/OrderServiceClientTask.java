package com.narentech.tasks;

import java.util.concurrent.Callable;

import com.narentech.backends.OderStatusServiceClient;
import com.narentech.model.OrderStatusResp;
import com.narentech.model.TaskResult;

public class OrderServiceClientTask implements Callable<TaskResult>{
	
	private String oid;
	
	public OrderServiceClientTask(String oid) {
		this.oid = oid;
	}
	
	

	public TaskResult call() throws Exception {
		
		System.out.println("Enterd into OrderServiceClientTask");
		
		OderStatusServiceClient serviceClient = new OderStatusServiceClient();
		OrderStatusResp response = serviceClient.getOrderStatus(oid);
		
		TaskResult taskResult = new TaskResult();
		taskResult.setName("statusTask");
		taskResult.setResult(response);
		// TODO Auto-generated method stub
		System.out.println("Exit from OrderServiceClientTask");
		return taskResult;
	}

}
