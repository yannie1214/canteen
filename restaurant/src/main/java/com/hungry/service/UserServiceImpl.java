package com.hungry.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungry.beans.User;
import com.hungry.dao.UserDao;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	//注册 添加用户
//	@Override
//	public int addUser(String username, String password, String phone) {
//		return userDao.addUser(username, password, phone);
//	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 查询所有用户方法
	@Override
    public ArrayList<User> findAllUser(){
    	return userDao.findAllUser();
    }

	//登录 查询登录信息是否正确
	@Override
	public User findUser(User user) {
		User u=userDao.findUser(user);
		return u;
	}

	//注册 判断手机号是否存在
	public boolean findUserByPhone(User user) {
		User u=userDao.findUserByPhone(user);
		if(u!=null) {
			return true;
		}
		return false;
	}
	
	// 判断手机号是否存在（AJAX）
	public boolean findByPhone(String phone) {
        User u=userDao.findByPhone(phone);
        if(u==null) {
			return true;//手机号可用
		}
		return false;
	}
	
	//注册 添加用户
	public int addUser(User user) {
		return userDao.addUser(user);	
	}

	@Override
	public void updateUser(int user_id,String username,String password,String phone) {
		
		 userDao.updateUser(user_id,username,password,phone);
	}
	
}
