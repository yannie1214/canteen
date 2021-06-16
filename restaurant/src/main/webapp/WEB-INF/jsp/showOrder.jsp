<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	下单成功！
	<br>
	<%-- <a href="${pageContext.request.contextPath}/showOrder.do">我的订单</a> --%>
	<form action="${pageContext.request.contextPath }/showOrder.do" method="post" id="form">
	<input name="user_id" id="user_id"/>
        <button value="提交订单" type="submit"/>
		</form>
</body>
</html>