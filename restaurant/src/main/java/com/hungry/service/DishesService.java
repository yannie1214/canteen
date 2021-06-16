package com.hungry.service;

import java.util.List;

import com.hungry.beans.Category;
import com.hungry.beans.Dishes;
import com.hungry.beans.StarAssess;

public interface DishesService {

	void addDishes(Dishes dishes);

	List<Dishes> findAllDishes();

	Dishes findDishesById(int dishes_id);

	void modifyDishes(int id,double price,String name,String describe,String photo,String cname);

	void removeDishes(int id);

	List<Category> getCate();
	
	void assessStar(StarAssess st);
	StarAssess queryAssess(StarAssess sa);
	void modifyStarAssess(StarAssess sa);
	List<StarAssess> queryAllAssess();

	List<Dishes> getByType(String dishes_cname);
	
}
