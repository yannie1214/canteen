package com.hungry.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hungry.beans.Category;
import com.hungry.service.CategoryService;

@Controller //分类管理
public class CategoryController{
	
	@Autowired
	//@Qualifier("cateService")
	private CategoryService service;
	

	public void setService(CategoryService service) {
		this.service = service;
	}
	
	@RequestMapping("/cate.do")
	@CrossOrigin
	@ResponseBody
	public List<Category> cate(Model model) {
		List<Category> list = service.getAllCate();
//		model.addAttribute("list", list);
//		
//		return "admin/admin_cate";
		return list;
	}
	
//	@RequestMapping("/toaddcate.do")
//	@CrossOrigin
//	@ResponseBody
//	public String toAddCate() {
//		
//		return "admin/admin_addcate";
//	}
	
	@RequestMapping("/addCate.do")
	@CrossOrigin
	@ResponseBody
	public Category addCate(String dishes_cname) {
		Category cate = new Category(dishes_cname);
		
		service.addCate(cate);
//		
//		return "redirect:/cate.do";
		return cate;
	}
	
	@RequestMapping("/removecate.do")
	@CrossOrigin
	@ResponseBody
	public boolean removeCate(int id){
		service.removeCate(id);
		
		//return "redirect:/cate.do";
		return true;
	}
	
	@RequestMapping("/modifycate.do")
	@CrossOrigin
	@ResponseBody
	public Category modifyCate(int id,String dishes_cname){ 
		service.modifyCate(id,dishes_cname);
		
		Category cate=new Category(id,dishes_cname);
		return cate;
	}
	
}
