package com.hungry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungry.beans.Order;
import com.hungry.beans.OrderItem;
import com.hungry.dao.IShowOrderDao;


@Service
public class ShowOrderServiceImpl implements IShowOrderService {
	@Autowired
	private IShowOrderDao dao;
	
	public void setDao(IShowOrderDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Order> getOrdersByUserId(int uid) {
		List<Order>orders = dao.getOrdersByUserId(uid);
		for(int i=0;i<orders.size();i++) {
			//根据订单的id获取订单详情，一个订单可能有多个订单详情
			List<OrderItem> items = dao.getItemsByOrderId(orders.get(i).getId());
			//将订单详情存放在订单中
			orders.get(i).setItems(items);	
			}
		return orders;
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order>orders = dao.getAllOrders();
		for(int i=0;i<orders.size();i++) {
			//根据订单的id获取订单详情，一个订单可能有多个订单详情
			List<OrderItem> items = dao.getItemsByOrderId(orders.get(i).getId());
			//将订单详情存放在订单中
			orders.get(i).setItems(items);	
			}
		return orders;
	}

	@Override
	public Order getItemsByOrderId(int order_id) {
		List<OrderItem> orderitem=dao.getItemsByOrderId(order_id);
		Order order=dao.selectOrderByOrderId(order_id);
		order.setItems(orderitem);
		return order;
	}

}
