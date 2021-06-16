package com.hungry.handlers;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hungry.beans.Dishes;
import com.hungry.beans.StarAssess;
import com.hungry.beans.starAssessItem;
import com.hungry.service.DishesService;

@Controller
public class showAssessController  {
	@Autowired
	private DishesService service;
	  
	 public void setService(DishesService service) {
	 	this.service = service;
	 }
	 @RequestMapping("/showAssess.do")
	 @CrossOrigin
		@ResponseBody
	public List<starAssessItem> handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mv=new ModelAndView();
		List<StarAssess> starList=new ArrayList<StarAssess>();
		List<starAssessItem> starItemList=new ArrayList<starAssessItem>();
		starList=service.queryAllAssess();
		Dishes d=new Dishes();
		int scale =0;
		int roundingMode=4;
		for(StarAssess sa:starList) {
			d=service.findDishesById(sa.getDishesId());
			BigDecimal bd =new BigDecimal((double)sa.getStarLevel());
			bd=bd.setScale(scale, roundingMode);
			sa.setStarLevel(bd.floatValue());//��ƽ�������������������
			if(sa.getStarLevel()>=4.0) {
			starAssessItem starItem=new starAssessItem(d,sa.getStarLevel());
			starItemList.add(starItem);}		
		}
//		System.out.println(starItemList.toString());
//		HttpSession session=request.getSession();
//		session.setAttribute("starItemList", starItemList);
		return starItemList;
//		mv.setViewName("showAssess");
//		return mv;
	}

}
