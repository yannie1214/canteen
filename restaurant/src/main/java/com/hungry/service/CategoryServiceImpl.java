package com.hungry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungry.beans.Category;
import com.hungry.dao.ICategoryDao;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private ICategoryDao dao;
	
	
	  public void setDao(ICategoryDao dao) { 
		  this.dao = dao; 
	}
	 
	
	@Override
	public void addCate(Category cate) {
		dao.insertCate(cate);
	}
	
	@Override
	public List<Category> getAllCate() {
		return dao.selectAllCate();
	}
	
	@Override
	public void removeCate(int id) {
		dao.deleteCate(id);
	}


	@Override
	public void modifyCate(int dishes_cid,String dishes_cname) {
		
		dao.modifyCate(dishes_cid,dishes_cname);
		
	}

}
