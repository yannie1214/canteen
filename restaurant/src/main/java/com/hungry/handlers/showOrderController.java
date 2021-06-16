package com.hungry.handlers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import com.hungry.beans.Order;
import com.hungry.beans.OrderItem;
import com.hungry.service.IShowOrderService;
@Controller
public class showOrderController {
	 @Autowired
	private IShowOrderService service;
	
	

	public void setService(IShowOrderService service) {
		this.service = service;
	}
	@RequestMapping("/showOrder.do")//展示用户订单
	@CrossOrigin
	@ResponseBody
	public List<Order> handleRequest(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//Integer user_id=(int) session.getAttribute("user_id");
		Integer user_id=Integer.parseInt(request.getParameter("user_id"));
		List<Order> orders = service.getOrdersByUserId(user_id);
		return orders;
	}
	
	@RequestMapping("/showAllOrder.do")//展示所有订单
	@CrossOrigin
	@ResponseBody
	public List<Order> showAllOrder(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		List<Order> orders = service.getAllOrders();

		return orders;
	}
	@RequestMapping("/findOrderItem.do")//展示订单详情
	@CrossOrigin
	@ResponseBody
	public Order findOrder(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
	//	Integer user_id=Integer.parseInt(request.getParameter("user_id"));
		int order_id=Integer.parseInt(request.getParameter("order_id"));
		Order orderItems=service.getItemsByOrderId(order_id);
		return orderItems;
	}

	
}
