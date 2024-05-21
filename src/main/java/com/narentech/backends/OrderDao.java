package com.narentech.backends;

import com.narentech.model.OrderDaoResponse;

public class OrderDao {
	
	public OrderDaoResponse getOrder(String oid) {
		OrderDaoResponse daoResp = new OrderDaoResponse();
		daoResp.setName("mobile");
		daoResp.setPrice(10000);
		daoResp.setQty(12);
		return daoResp;
		
	}

}
