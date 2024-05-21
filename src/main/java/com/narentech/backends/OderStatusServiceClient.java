package com.narentech.backends;

import com.narentech.model.OrderStatusResp;

public class OderStatusServiceClient {
	
	public OrderStatusResp getOrderStatus(String oid) {
		OrderStatusResp statusResp = new OrderStatusResp();
		statusResp.setStatus("delivered");
		statusResp.setDesc("good");
		return statusResp;
		
	}

}
