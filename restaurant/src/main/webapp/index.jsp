<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<span id="user">${cookie.username.value }</span><p></p>
查看<button onclick="show()">查看</button>
<br>
<button onclick="logout()">注销</button>
</body>
<script src="https://cdn.staticfile.org/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript">
	function show(){
		$.ajax({
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("token", $.cookie('token'));
            },
		    type: "GET",
		    url: "http://localhost:8080/Hungry/showAll.do",
		
		    success:function(result){
		    	  console.log(result);
		    	
		    }
		});
	}
	/**
     * 请求数据的ajax，需要从cookie读取token放入head传给后台。
     */
     loadDeptTree();
	function loadDeptTree() {
        console.log('获取到的token = ' + $.cookie('token'));
	    $.ajax({
	    	  // 自定义的headers字段，会出现option请求，在GET请求之前，后台要记得做检验。
            beforeSend: function (XMLHttpRequest) { 
                XMLHttpRequest.setRequestHeader("token", $.cookie('token'));
            },
	        url: "http://localhost:8080/Hungry/showAll.do",
	        type: 'GET',
	        dataType: 'json',
	        success : function (result) {
				$('#user').jsp($.cookie('username'));
                console.log(result);
				if(result.code==200){
					alert("加载到的数据："+result+",并进行渲染页面....");
				}else{
					alert("异常,非法token，这里不直接判断是否token不对，实际开发需要各种判断返回码");
				}
	        }
	    })
    }
    
    /**
     * æ³¨éï¼æ¸ç©ºææcookie(æèåªæ¸ç©ºä¿å­çtokençCookieå°±è¡)
     */
	function logout() {
	    var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
	    if(keys) {
	        for(var i = keys.length; i--;)
	            document.cookie = keys[i] + '=0;expires=' + new Date(0).toUTCString()
	    }
	    //è¿åç»å½é¡µé¢æèä¸»é¡µ
	    window.location.href = "login.html";
	}
</script>

</html>