package com.hungry.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hungry.beans.Category;

public interface ICategoryDao {

	void insertCate(Category cate);

	List<Category> selectAllCate();

	void deleteCate(int id);

	void modifyCate(@Param("dishes_cid")int dishes_cid,@Param("dishes_cname")String dishes_cname);
	
}
