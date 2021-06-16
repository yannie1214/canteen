<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/login.css"/>

<html>
<head><title>登录页面</title></head>

<body>
<form id="postFrom" action=""></form>
<input type="text" name="phone" value="" required/>
<input type="password" name="password" value=""  required/>
<input type="text" name="identity" value="customer"/>
<input type="submit" onclick="login()" value="登录">
<button id="submitButton" type="button">submit</button>
</body>

<script type="text/javascript">
/*  $(function() {
    // 这里url为能映射到controller方法里的地址，使情况而定
    var postUrl = "http://localhost:8080/Hungry/login.do";
    // 点击按钮触发ajax提交请求
    $("#submitButton").click(function () {
        $.ajax( {
            type : "post",
            url : postUrl,
            datatype : "json",
            data : $("#postForm").serialize(),
            success: function(res) {
                if(res.code == 200) {
                    console.log(res);
                    //ä¿å­tokenç¨æ¥å¤æ­ç¨æ·æ¯å¦ç»å½ï¼åèº«ä»½æ¯å¦å±å®
                    $.cookie('token', res.data.token);
                    $.cookie('username', res.data.user.username);
					$.cookie('user', res.data.user);
					//è½¬åä¸»é¡µé¢
					location="index.jsp";
                } else {
                    alert("用户名或者密码错误");
                }
            },
            error: function(err) {
                console.log(err);
            }

        });
    });
});  */
/*   function login() {
        let phone = $("input[name='phone']").val();
        let password = $("input[name='password']").val();
        let identity =$("input[name='identity']").val();
        let user_id=$("input[name='user_id']").val();
        let username=$("input[name='username']").val();
/*    var user=JSON.stringify.({   	
            phone: phone,
            password: password,
            identity:identity        
        });  */
        $.ajax({
            url: "http://localhost:8080/Hungry/login.do",
            type: "POST",
            dataType: "json",
            data:{   	
            	user_id:user_id,
 				username:username,           	
                phone: phone,
                password: password,
                identity:identity        
            },
            success: function(res) {
                if(res.code == 200) {
                    console.log(res);
                    //ä¿å­tokenç¨æ¥å¤æ­ç¨æ·æ¯å¦ç»å½ï¼åèº«ä»½æ¯å¦å±å®
                    $.cookie('token', res.data.token);
                    $.cookie('username', res.data.user.username);
					$.cookie('user', res.data.user);
					//è½¬åä¸»é¡µé¢
					location="index.jsp";
                } else {
                    alert("用户名或者密码错误");
                }
            },
            error: function(err) {
                console.log(err);
            }
        })
    }   */
</script>

</html>

