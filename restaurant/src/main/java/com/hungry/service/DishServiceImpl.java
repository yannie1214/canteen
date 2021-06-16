package com.hungry.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungry.beans.Category;
import com.hungry.beans.Dishes;

import com.hungry.dao.DishesDao;


@Service
public class DishServiceImpl implements DishService {
	@Autowired
	private DishesDao dishDao;
	   public void setDishesDao(DishesDao dis) { 
		   dishDao=dis; 
	   }
	 	@Override
	public List<Dishes> getAllList() {		
		return dishDao.getAllList();
	}

	@Override
	public Dishes findById(Integer dishes_id) {
		
		return dishDao.findById(dishes_id);
	}

	@Override
	public List<Dishes> getByType(String dishes_cname) {
		
		return dishDao.getByType(dishes_cname);
	}

	@Override
	public List<Category> getAllCategory() {
		
		return dishDao.getAllCategory();
	}
	
	@Override
	public List<Dishes> findByWord(String word) {
		
		return dishDao.findByWord(word);
	}
	
	//展示上月销量前10的菜品
	@Override
    public ArrayList<Dishes> showTopSales(String year,String month){
    	return dishDao.showTopSales(year,month);
    }
	
    public String getImage(String path) {
        String photo = "";
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            int count = 0;
            while (count == 0) {
                count = fis.available();
            }
            byte[] read = new byte[count];
            System.err.println(read);
            fis.read(read);
            photo = Base64.getEncoder().encodeToString(read);
            System.err.println("返回前端的base64图片字符串:"+photo);
        } catch (Exception e) {
			e.printStackTrace();
        }
        return  photo;
    }
}
