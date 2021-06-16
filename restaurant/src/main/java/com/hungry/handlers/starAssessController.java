package com.hungry.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hungry.beans.StarAssess;
import com.hungry.service.DishesService;


@Controller
public class starAssessController  {
	@Autowired
	private DishesService service;
	  
	 public void setService(DishesService service) {
	 	this.service = service;
	 }
     
	@RequestMapping("/assess.do")
	@CrossOrigin
	@ResponseBody
	public boolean handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Float starLevel=(float) 0.0;
		int num=1;
		ModelAndView mv=new ModelAndView();
		float starlevel=Float.parseFloat(request.getParameter("assessment"));
		int dishesId=Integer.parseInt(request.getParameter("id"));
		StarAssess sa=new StarAssess(dishesId,starlevel,num);
		StarAssess SA=service.queryAssess(sa);
		if(SA!=null)
		{
			num=SA.getNumber()+1;
			sa.setNumber(num);
			starLevel=(SA.getStarLevel()*SA.getNumber()+sa.getStarLevel())/sa.getNumber();
			sa.setStarLevel(starLevel);
			service.modifyStarAssess(sa);
		}
		else{service.assessStar(sa);}
//		mv.setViewName("redirect:/showAssess.do");
//		return mv;
		return true;
	}

}
