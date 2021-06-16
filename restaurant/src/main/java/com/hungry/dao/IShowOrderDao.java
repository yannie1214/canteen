package com.hungry.dao;

import java.util.List;

import com.hungry.beans.Order;
import com.hungry.beans.OrderItem;

public interface IShowOrderDao {

	List<Order> getOrdersByUserId(int uid);

	List<OrderItem> getItemsByOrderId(int id);
	
	List<Order> getAllOrders();
	Order selectOrderByOrderId(int id);
	
}
