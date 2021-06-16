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

import com.hungry.beans.Cart;
import com.hungry.service.CartService;
@Controller
public class addToCartController  {
	@Autowired
	 private CartService service;
	  
	 public void setService(CartService service) {
	 	this.service = service;
	 }

	 @RequestMapping("/addToCart.do")
	 @CrossOrigin
	@ResponseBody
	public boolean handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	//	ModelAndView mv2=new ModelAndView();
		 int dishesId=0;
	        int quantity1=1;
	        int quantity2=0;
	        try {
	            dishesId = Integer.parseInt(request.getParameter("id"));
	        } catch (NumberFormatException e) {
	        	System.out.println(e);	
	        }
	   //     HttpSession session = request.getSession();
	       int U_id=Integer.parseInt(request.getParameter("user_id"));
	        //int U_id=(int)session.getAttribute("user_id");
	        Cart c1=new Cart();
	        Cart c2=new Cart(dishesId,U_id,quantity1);
	        c1=service.queryCart(c2);
	        boolean flag=false;
	        if(c1!=null) {
	        quantity2=1+c1.getQuantity();
	        c1.setQuantity(quantity2);
	        service.addToCartByModify(c1);
	        flag=true;
	        }else {
	        	service.addToCart(c2);
	        	flag=true;
	        }
	      //  mv2.setViewName("list");
		//return mv2;
	        return flag;
	}

}
