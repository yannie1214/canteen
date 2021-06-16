package com.hungry.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hungry.beans.User;
import com.hungry.service.UserService;
import com.hungry.token.JWTUtil;
import com.hungry.token.ResponseData;



@Controller
public class UserController {

	@Autowired
	private UserService UserService;
	
	//登录
	  
	  @CrossOrigin
	@RequestMapping(value="/login.do")
	  @ResponseBody
	    public ResponseData login(String phone,String password,String identity) {
		  //String phone,String password,String identity
	    	User user=new User(phone,password,identity);
	        User login = UserService.findUser(user);
	        ResponseData responseData = ResponseData.ok();//返回200
	        if (login != null) {
	        	String uid=login.getUser_id()+"";
	            // 生成token
	            String token = JWTUtil.generateToken(uid, "Kuroko-Security-Basic", login.getUsername());
	            // 向浏览器返回token，客户端收到此token后存入cookie中，或者h5的本地存储
	            responseData.putDataValue("token", token);
	            login.setPassword("******");
	            responseData.putDataValue("user", login);//用户
	        } else {
	            // 用户名或者密码错误
	            responseData = ResponseData.customerError();
	        }
	        return responseData;
	    }


	//注册  添加用户 插入数据
	  @CrossOrigin
	@RequestMapping(value="/register.do")
	  @ResponseBody
	public boolean register(String username,String password,String phone,String identity,HttpServletResponse response) throws IOException{		
		    response.setContentType("text/html;charset=utf-8");
  	       // PrintWriter out=response.getWriter();
		    User user=new User(username,password,phone,identity);
			int addUser=UserService.addUser(user);
			if(addUser!=0){	      
				return true;
//				out.print("<script>alert('注册成功!')</script>");
//				out.flush();
//	        	return "../../login";
	        }
	        else {	        
	        	return false;
//	        	out.print("<script>alert('注册失败!')</script>");
//				out.flush();
//				return "../../register";	        
			}
	}
	
	
	// 异步检验手机号是否存在
	  @CrossOrigin
	@ResponseBody
	@RequestMapping(value="/validPhone.do")
	public boolean validPhone(String phone) {		
		  boolean tip=UserService.findByPhone(phone);
		return tip;//true表示号码可用
	}
	
	//注销 退出登录
	@RequestMapping(value="/logout.do")
	@CrossOrigin
	@ResponseBody
	public boolean logout(HttpSession session) {		
		try {
//			session.removeAttribute("user");
			session.invalidate();
        }catch (Exception e){;
        	e.printStackTrace();
        }
		
		return true;
	}
	
	//修改用户信息
	@RequestMapping(value="/modifyUser.do")
	@CrossOrigin
	@ResponseBody
	public boolean modifyUser(String username,String password,String phone,HttpSession session,HttpServletRequest request) {
		//int user_id=(int) session.getAttribute("user_id");
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		User user=new User(user_id,username,password,phone,null);
		UserService.updateUser(user_id,username,password,phone);
		return true;
	}
	
}
