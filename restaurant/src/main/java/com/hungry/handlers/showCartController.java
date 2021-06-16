package com.hungry.handlers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import com.hungry.beans.Cart;
import com.hungry.beans.Dishes;
import com.hungry.beans.DishesItem;
import com.hungry.service.CartService;
@Controller
public class showCartController {
	 @Autowired
	 private CartService service;
	
	 public void setService(CartService service) {
	 	this.service = service;
	 }

	 @RequestMapping("/showCart.do")
	 @CrossOrigin
		@ResponseBody
	public List<DishesItem> handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		//int U_id=(int) session.getAttribute("user_id");
		int U_id=Integer.parseInt(request.getParameter("user_id"));
		List<Cart> cartList =new ArrayList<Cart>();
		List<DishesItem> diList=new ArrayList<DishesItem>();
		cartList=service.displayCart(U_id);
	
		Dishes dishes=new Dishes();
		for(Cart cart:cartList){
			dishes=service.showDishes(cart.getD_id());
			//System.out.println(dishes.toString());
			DishesItem di=new DishesItem(dishes,cart.getQuantity());
			
			diList.add(di);
			//System.out.println(diList.get(0).toString());
		}
		
	//	session.setAttribute("diList", diList);
//		mv.setViewName("showCart");
//		return mv;
		return diList;
	}

}
