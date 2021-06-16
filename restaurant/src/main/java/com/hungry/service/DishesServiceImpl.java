package com.hungry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungry.beans.Category;
import com.hungry.beans.Dishes;
import com.hungry.beans.StarAssess;
import com.hungry.dao.DishesDao;
@Service
public class DishesServiceImpl implements DishesService {
	@Autowired
	private DishesDao dao;
	
	
	  public void setDao(DishesDao dao) { this.dao = dao; }
	 
	
	@Override
	public void addDishes(Dishes dishes) {
		dao.insertDishes(dishes);
	}

	@Override
	public List<Dishes> findAllDishes() {
		return dao.getAllList();
	}

	@Override
	public Dishes findDishesById(int dishes_id) {
		return dao.findById(dishes_id);
	}

	@Override
	public void modifyDishes(int id,double price,String name,String describe,String photo,String cname) {
		dao.updateDishes(id,price,name,describe,photo,cname);
	}

	@Override
	public void removeDishes(int id) {
		dao.deleteDishes(id);
	}

	@Override
	public List<Category> getCate() {
		return dao.getAllCategory();
	}


	@Override
	public void assessStar(StarAssess st) {
		// TODO Auto-generated method stub
		dao.insertAssess(st);
	}


	@Override
	public StarAssess queryAssess(StarAssess st) {
		// TODO Auto-generated method stub
		StarAssess sa=dao.selectAssess(st);
		return sa;
	}


	@Override
	public void modifyStarAssess(StarAssess sa) {
		// TODO Auto-generated method stub
		dao.updateStarAssess(sa);
	}


	@Override
	public List<StarAssess> queryAllAssess() {
		// TODO Auto-generated method stub
		List<StarAssess> list=null;
		list=dao.selectAllAssess();
		return list;
	}


	@Override
	public List<Dishes> getByType(String dishes_cname) {
		// TODO Auto-generated method stub
		return dao.getByType(dishes_cname);
				
	}
}
