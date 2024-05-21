package com.narentech.service;

import java.io.Serial;
import java.util.concurrent.ExecutionException;

import com.narentech.model.OrderResponse;

public class OrderServiceMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		OrderService orderService = new OrderService();
		OrderResponse response = orderService.getOrder("123");
		System.out.println("final response"+response);
		// TODO Auto-generated method stub

	}

}
