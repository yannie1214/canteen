package com.hungry.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.hungry.beans.User;

public interface UserDao {
	
	
	// 查询所有用户方法
    public ArrayList<User> findAllUser();

    //登录 查询登录信息是否正确
	public User findUser(User user);
	
	//注册 判断手机号是否存在
	public User findUserByPhone(User user);
	
	//注册 判断手机号是否存在(AJAX)
	public User findByPhone(String phone);
	
	//注册 添加用户
	public int addUser(User user);
	//修改用户信息
	public void updateUser(@Param("user_id")int user_id,@Param("username")String username,@Param("password")String password,@Param("phone")String phone);
	
	
}
