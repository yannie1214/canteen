package com.hungry.handlers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hungry.beans.Category;
import com.hungry.beans.Dishes;
import com.hungry.service.DishesService;


@Controller //管理员菜品管理
public class DishesController{
	
	@Autowired
	//@Qualifier("dishesService")
	private DishesService service;
	
	public void setService(DishesService service) {
		this.service = service;
	}
	
	@RequestMapping("/dishes.do")//展示菜品
	@CrossOrigin
	@ResponseBody
	public List<Dishes> dish(Model model) {
		List list=service.findAllDishes();		
		return list;
		//return "admin/admin_dishes";
	}
	
	@RequestMapping("/getcate.do")//展示分类
	@CrossOrigin
	@ResponseBody
	public List<Category> getCate(){
		
		return service.getCate();
	}
	
//	@RequestMapping("/toadddishes.do")
//	public String toAddDishes(Model model){
//		List<Dishes> list = service.findAllDishes();
//		model.addAttribute("list", list);
//		model.addAttribute("clist", getCate());
//		//return list;
//		return "admin/admin_adddishes";
//		
//	}
	@RequestMapping("/upload.do")//添加菜品
	@CrossOrigin
	@ResponseBody
	public boolean setPhoto(MultipartFile photo) throws IllegalStateException, IOException{
		String fileName = null;
		if (photo.getSize() > 0) { 
			// 获取到上传文件的原始名称
			fileName = photo.getOriginalFilename();
			//String path = this.getClass().getResource("/").getPath() + "/"+fileName;
			String path="C:/Tomcat/apache-tomcat-9.0.37/webapps/Hungry/images/"+fileName;
			if (fileName.endsWith("jpg") || fileName.endsWith("png")) {
				File file = new File(path);
				photo.transferTo(file);
				return true;
			}
		}
	//	String fileName1="123.60.33.16:8080/images/"+fileName;
		return false;
		
	}
	
	@RequestMapping("/adddishes.do")//添加菜品
	@CrossOrigin
	@ResponseBody
	public Dishes addDishes(String price,String dishes_name,String dishes_describe,
			String photo,String dishes_cname, HttpServletRequest request) throws IllegalStateException, IOException{
		double dishes_price = Double.parseDouble(price);
//		String fileName = null;
//		if (photo.getSize() > 0) { 
//			// 获取到上传文件的原始名称
//			fileName = photo.getOriginalFilename();
			//String path = this.getClass().getResource("/").getPath() + "/"+fileName;
//			String path="C:/Tomcat/apache-tomcat-9.0.37/webapps/Hungry/images";
//			if (fileName.endsWith("jpg") || fileName.endsWith("png")) {
//				File file = new File(path);
//				photo.transferTo(file);
//			}
//		}
		String fileName="http://123.60.33.16:8080/Hungry/images/"+photo;
		Dishes dishes = new Dishes(dishes_price,dishes_name,dishes_describe,dishes_cname,fileName);
		service.addDishes(dishes);
		return dishes;
		//return "redirect:/dishes.do";
	}
	
	@RequestMapping("/finddishesbyid.do")//菜品详情
	@CrossOrigin
	@ResponseBody
	public Dishes findDishesById(int dishes_id,Model model) {
		Dishes dish = service.findDishesById(dishes_id);
		model.addAttribute("dish", dish);
		return dish;
		//return "admin/admin_finddishesbyid";
	}
	
//	@RequestMapping("/tomodifydishes.do")
//	@CrossOrigin
//	@ResponseBody
//	public String toModifyDishes(int id,double price,String name,String describe,
//			String photo,String cname,Model model) {
//		model.addAttribute("id", id);
//		model.addAttribute("price", price);
//		model.addAttribute("name", name);
//		model.addAttribute("describe", describe);
//		model.addAttribute("photo", photo);
//		model.addAttribute("cname", cname);
//		model.addAttribute("list", getCate());
//		
//		return "admin/admin_modifydishes";
//	}
	
	@RequestMapping("/modifydishes.do")//修改菜品
	@CrossOrigin
	@ResponseBody
	public Dishes modifyDishes(int dishes_id,double price,String name,String describe,
			String cname,String photo,Model model) throws IllegalStateException, IOException {
		
//		String path="C:/Tomcat/apache-tomcat-9.0.37/webapps/Hungry/images";
//		String fileName = null;
//		if (photo.getSize() > 0) {
//			// 获取到上传文件的原始名称
//			fileName = photo.getOriginalFilename();
//			if (fileName.endsWith("jpg") || fileName.endsWith("png")) {
//				File file = new File(path, fileName);
//				photo.transferTo(file);
//			}
//		}
		String fileName="http://123.60.33.16:8080/images/"+photo;
		service.modifyDishes(dishes_id,price,name,describe,fileName,cname);
		Dishes dishes = new Dishes(dishes_id,price,name,describe,fileName,cname);
		return dishes;
		//return "redirect:/dishes.do";
	}
	
	@RequestMapping("/removedishes.do")
	@CrossOrigin
	@ResponseBody
	public boolean removeDishes(int id) {
		service.removeDishes(id);	
		return true;
	}
	
}
