package com.hungry.handlers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hungry.beans.Cart;
import com.hungry.beans.DishesItem;
import com.hungry.service.CartService;
@Controller
public class modifyQuantityController {
	@Autowired
	 private CartService service;
  
	 @RequestMapping("/modifyQuantity.do") 
	 @CrossOrigin
		@ResponseBody
	public boolean handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		 //ModelAndView mv=new ModelAndView();
		int U_id=Integer.parseInt(request.getParameter("user_id"));
			int dishesId=0;
			HttpSession session=request.getSession();
		//	int U_id=(int) session.getAttribute("user_id");
			int Quantity=0;
			dishesId = Integer.parseInt(request.getParameter("id"));
			Quantity = Integer.parseInt(request.getParameter("number"));
			Cart cart=new Cart(dishesId,U_id,Quantity);
			if(Quantity!=0) {
			service.addToCartByModify(cart);}
			else {
				service.removeFromCart(cart);
			}
			//mv.setViewName("showCart.do");
			/*
			 * int dishesId=0; int U_id=1; int Quantity=0; dishesId =
			 * Integer.parseInt(request.getParameter("id")); ServletContext context
			 * =request.getServletContext(); ArrayList<DishesItem>
			 * diList=(ArrayList<DishesItem>) context.getAttribute("diList"); for(DishesItem
			 * dishesItem:diList) { if(dishesItem.getDishes().getDishes_id()==dishesId) {
			 * Quantity=dishesItem.getQuantity()+1; break; } } Cart cart=new
			 * Cart(dishesId,U_id,Quantity); service.addToCartByModify(cart);
			 * mv.setViewName("showCart.do");
			 */
			
			return true;
	}

}
