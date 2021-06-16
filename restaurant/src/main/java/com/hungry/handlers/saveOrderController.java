package com.hungry.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import com.hungry.service.IOrderService;
@Controller
public class saveOrderController {
	 @Autowired
	private IOrderService service;
	
	public void setService(IOrderService service) {
		this.service = service;
	}
	 @RequestMapping("/saveOrder.do")
	 @CrossOrigin
		@ResponseBody
	public boolean handleRequest(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		//获取已提交表单的数据，这里的id先设置输入获取，等项目整合之后再用session获取user对象
		String totalAmount =(String) request.getParameter("totalAmount");		//获取订单总金额
		String aNum_id = '#'+(String)request.getParameter("dishesInfo");//获取#订单商品数量_商品id
		Integer Uid=Integer.parseInt(request.getParameter("user_id"));
		service.saveOrder(totalAmount,aNum_id,Uid);
		
	//	return new ModelAndView ("showOrder");
		return true;
	}

}