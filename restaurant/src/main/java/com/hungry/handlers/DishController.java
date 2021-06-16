package com.hungry.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hungry.beans.Category;
import com.hungry.beans.Dishes;
import com.hungry.service.DishService;

import org.springframework.stereotype.Controller;



@Controller  //顾客菜品
public class DishController {
	
	@Autowired
	private DishService dishServiceimpl;
	
	@RequestMapping("/showAll.do") //展示所有菜品
	@CrossOrigin
	@ResponseBody
	public List<List<Dishes>> dish(Model model) {
		List<Category> typelist = dishServiceimpl.getAllCategory();
		int i;
		List<Dishes> list=null;
		List<List<Dishes>> slist=new ArrayList<List<Dishes>>();
		for(i=0;i<typelist.size();i++) {
			String dishes_cname=typelist.get(i).getDishes_cname();
			list=dishServiceimpl.getByType(dishes_cname);
//			for(int j=0;j<list.size();j++) {
//				String photo=this.getImage(list.get(j).getPhoto());
//				list.get(j).setPhoto(photo);
//			}
			slist.add(list);		
		}
		
		return slist;
		//return "admin/admin_dishes";
	}
	@RequestMapping("/showType.do") //展示分类菜品
	@CrossOrigin
	@ResponseBody
	public List<Dishes> showType(String dishes_cname,Model model) {
		List<Dishes> list=dishServiceimpl.getByType(dishes_cname);
//		for(int j=0;j<list.size();j++) {
//			String photo=this.getImage(list.get(j).getPhoto());
//			list.get(j).setPhoto(photo);
//		}
		//model.addAttribute("list", list);	
		//return "list";
		return list;
	}
	@RequestMapping("showDish.do")//菜品详情
	@CrossOrigin
	@ResponseBody
	public Dishes showDish(Integer dishes_id,Model model) {
		Dishes dish=dishServiceimpl.findById(dishes_id);
	//	String photo=this.getImage(dish.getPhoto());
	//	dish.setPhoto(photo);
		return dish;
		//return "show";
	}
	
//	//@RequestMapping("/showAllType")//展示分类
//	public void showAllCategory(Model model) {
//		List <Dishes_category> category_list=dishServiceimpl.getAllCategory();
//		model.addAttribute("category_list", category_list);	
//		//return "showCategory";
//	}
	
	@RequestMapping(value="findByWord.do")//搜索菜品
	@CrossOrigin
	@ResponseBody
	public List<Dishes> findByWord(String word,Model model) {
		List<Dishes> list=dishServiceimpl.findByWord(word);
//		for(int j=0;j<list.size();j++) {
//			String photo=this.getImage(list.get(j).getPhoto());
//			list.get(j).setPhoto(photo);
//		}
		return list;
	}


	//展示上月销量前10的菜品
	@RequestMapping("/recommend.do")
	@CrossOrigin
	@ResponseBody
	public ArrayList<Dishes> showTopSales(Model model) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String year=String.format("%tY", m);
	    String month=String.format("%tm", m); 	    
		ArrayList<Dishes> topDishList = dishServiceimpl.showTopSales(year,month);
//		for(int j=0;j<topDishList.size();j++) {
//			String photo=this.getImage(topDishList.get(j).getPhoto());
//			topDishList.get(j).setPhoto(photo);
//		}
		return topDishList;
		
	}	
	
//	@RequestMapping("/setPhoto.do")
//	@CrossOrigin
//	@ResponseBody
//    public String getImage(String path) {
//        String imageString = "";
//        try {
//            FileInputStream fis = new FileInputStream(new File(path));
//            int count = 0;
//            while (count == 0) {
//                count = fis.available();
//            }
//            byte[] read = new byte[count];
//            System.err.println(read);
//            fis.read(read);
//            imageString = Base64.getEncoder().encodeToString(read);
//            System.err.println("返回前端的base64图片字符串:"+imageString);
//        } catch (Exception e) {
//			e.printStackTrace();
//        }
//        return  imageString;
//    }

	
//	    public String sendImg(String photo,HttpServletResponse response) {
//	        try {
//	            FileInputStream fis = new FileInputStream(new File(photo));
//	            if(photo.contains("jpg")) {
//	            response.setContentType("image/jpg");}
//	            else {
//	            	response.setContentType("image/png");
//	            }
//	            OutputStream out = response.getOutputStream();
//	            byte[] buff = new byte[1024];
//	            int rc = 0;
//	            while ((rc = fis.read(buff, 0, 1024)) > 0) {
//	                out.write(buff, 0, rc);
//	            }
//	            out.flush();
//	            out.close();
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	        return null;
//	    }


}
