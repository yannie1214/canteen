<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/login.css"/>
<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
  function custCheck(){
	  var password=document.getElementById("password");
	  var againpassword=document.getElementById("againpassword");
	  var phone=document.getElementById("phone");
	  var identity=document.getElementById("identity");
	   	  
	  if(password.value.length<6){
		  alert("密码位数不可小于6！");
		  return false;
	  }
	  
	  if(password.value.length>18){
		  alert("密码位数不可大于18！");
		  return false;
	  }
	  
	  if(password.value!=againpassword.value){
		  alert("确认密码错误！");
		  return false;
	  }
	  
	  if(phone.value.length!=11){
		  alert("手机号应是11位数字！");
		  return false;
	  }	    
  } 
  
  function validPhone(obj){	  
	  if(obj.value!=null && obj.value!=""){ 
		  $.ajax({		  
			  type:"POST",
			  url:"${pageContext.request.contextPath }/validPhone.do",
			  data:"phone="+obj.value,			  
			  success:function(msg){
				  if(msg=="exist"){
					  alert("手机号已存在!");
					  obj.value="";
				  }
			  }
		  })
	  }
  } 
  
</script>

<html>
<head><title>注册页面</title></head>
<body>

<div class="reg">
<form action="${pageContext.request.contextPath }/register.do" method="post" onsubmit="return custCheck()">
<h1>注册</h1>
<p></p>
<p><input type="text" name="username" id="username" placeholder="请输入用户名" required/></p>
<p><input type="password" name="password" id="password" placeholder="请输入密码" required/></p>
<p><input type="password" name="againpassword" id="againpassword" placeholder="请确认密码" required/></p>
<p><input type="text" name="phone" id="phone" maxlength=11 onblur="validPhone(this)" placeholder="请输入手机号" required/></p>

<h4>身份: <select name="identity">
     <option value="customer">顾客</option>
     <option value="merchant">商家</option>
   </select>
</h4>
<p><input type="submit" name="" value="注册"></p>
<p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#">
            <使用条款和隐私策略>
</a></p>
<p class="txt"><a href="login.jsp"><span></span>已有账号登录</a></p>


</form> 
</div>
</body>
</html>