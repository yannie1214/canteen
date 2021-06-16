package com.hungry.service;

import java.util.ArrayList;
import java.util.List;

import com.hungry.beans.Category;
import com.hungry.beans.Dishes;


public interface DishService {
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
		//展示上月销量前10的菜品
		ArrayList<Dishes> showTopSales(String year,String month);
}
