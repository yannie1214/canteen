package com.hungry.service;

import java.util.List;

import com.hungry.beans.Category;

public interface CategoryService {

	void addCate(Category cate);

	List<Category> getAllCate();

	void removeCate(int id);
	void modifyCate(int id,String dishes_cname);
}
