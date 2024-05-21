package com.narentech.tasks;

import java.util.concurrent.Callable;

import com.narentech.backends.OrderDao;
import com.narentech.model.OrderDaoResponse;
import com.narentech.model.TaskResult;

public class OrderDaoTask implements Callable<TaskResult>{
	
	
	private String oid;
	
	public OrderDaoTask(String oid) {
		this.oid =oid;
	}

	public TaskResult call() throws Exception {
		System.out.println("Entered into orderdao task");
		
		OrderDao dao = new OrderDao();
		
		OrderDaoResponse daoResp =dao.getOrder(oid);
		
		TaskResult taskResult = new TaskResult();
		taskResult.setName("daoTask");
		taskResult.setResult(daoResp);
		
		
		System.out.println("Exit from orderdao task");
		// TODO Auto-generated method stub
		return taskResult;
	}

}
