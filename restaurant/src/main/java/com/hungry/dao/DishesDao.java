package com.hungry.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hungry.beans.Category;
import com.hungry.beans.Dishes;
import com.hungry.beans.StarAssess;


public interface DishesDao {
	//返回所有菜品
	List<Dishes> getAllList();
	//根据ID查询
	Dishes findById(Integer dishes_id);
	//根据菜品类型查询
	List<Dishes> getByType(String dishes_cname);
	//菜品分类
	List<Category> getAllCategory();
	//搜索查找
	List<Dishes> findByWord(String word);
	//新增菜品
	void insertDishes(Dishes dishes);
	//更新菜品
	void updateDishes(@Param("dishes_id")int id,@Param("dishes_price")double price,@Param("dishes_name")String name,@Param("dishes_describe")String describe,@Param("photo")String photo,@Param("dishes_cname")String dishes_cname);
	//删除菜品
	void deleteDishes(int id);
	//展示上月销量前10的菜品
	ArrayList<Dishes> showTopSales(String year,String month);
	void insertAssess(StarAssess st);
	StarAssess selectAssess(StarAssess sa);
	void updateStarAssess(StarAssess sa);
	List<StarAssess> selectAllAssess();//选出所有菜品的评价
}

