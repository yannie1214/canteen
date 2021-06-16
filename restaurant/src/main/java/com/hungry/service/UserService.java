package com.hungry.service;

import java.util.ArrayList;

import com.hungry.beans.User;

public interface UserService {

	//登录 查询
//	public boolean findUser(@Param("username")String username,@Param("password")String password);
		
	//查询手机号是否已存在
//	public boolean existUser(String phone);
	
	//注册 添加记录
//	public int addUser(String username,String password,String phone);
	
	// 查询所有用户方法
    public ArrayList<User> findAllUser();
    
    //登录 查询登录信息是否正确
	public User findUser(User user);
    
	//注册 判断手机号是否存在
	public boolean findUserByPhone(User user);

	//注册 添加用户
	public int addUser(User user);

	//注册 判断手机号是否存在(AJAX)
	public boolean findByPhone(String phone);
	//修改用户信息
		public void updateUser(int user_id,String username,String password,String phone);
}
