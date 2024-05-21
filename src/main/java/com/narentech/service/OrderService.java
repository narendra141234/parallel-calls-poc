package com.narentech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.narentech.model.OrderDaoResponse;
import com.narentech.model.OrderResponse;
import com.narentech.model.OrderStatusResp;
import com.narentech.model.TaskResult;
import com.narentech.tasks.OrderDaoTask;
import com.narentech.tasks.OrderServiceClientTask;

public class OrderService {
	
	public OrderResponse getOrder(String oid) throws InterruptedException, ExecutionException {
		
		OrderResponse response = new OrderResponse();
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		List tasks = new ArrayList();
		tasks.add(new OrderDaoTask(oid));
		tasks.add(new OrderServiceClientTask(oid));
		
		List<Future<TaskResult>> futureList = service.invokeAll(tasks);
		
		for(Future future : futureList) {
			TaskResult tr = (TaskResult)future.get();
			if("daoTask".equals(tr.getName())) {
				OrderDaoResponse daoResp = (OrderDaoResponse)tr.getResult();
				response.setName(daoResp.getName());
				response.setPrice(daoResp.getPrice());
				response.setQty(daoResp.getQty());
			}else if("statusTask".equals(tr.getName())) {
				OrderStatusResp statusResp = (OrderStatusResp)tr.getResult();
				response.setStatus(statusResp.getStatus());
				response.setDesc(statusResp.getDesc());
				
			}
			
		}
		
		return response;
		
	}
}
