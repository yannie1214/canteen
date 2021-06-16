package com.hungry.service;

import java.util.List;

import com.hungry.beans.Order;
import com.hungry.beans.OrderItem;



public interface IShowOrderService {

	List<Order> getOrdersByUserId(int uid);
	List<Order> getAllOrders();
	
	Order getItemsByOrderId(int order_id);
	
}
