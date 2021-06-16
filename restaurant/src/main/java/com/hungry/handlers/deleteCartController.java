package com.hungry.handlers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hungry.beans.Cart;

import com.hungry.service.CartService;
@Controller
public class deleteCartController {
	@Autowired
	 private CartService service;
  
	 @RequestMapping("/deleteCart.do") 
	 @CrossOrigin
		@ResponseBody
	public boolean handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int U_id=Integer.parseInt(request.getParameter("user_id"));
//			HttpSession session=request.getSession();
//			int U_id=(int) session.getAttribute("user_id");
			service.deleteCart(U_id);
			return true;
	}

}
