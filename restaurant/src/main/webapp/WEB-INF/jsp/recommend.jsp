<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>推荐销量菜品</title>
</head>
<body>
上月销量前10菜品<br>
	<c:forEach items="${topDishList}" var="dishes">
		<label>${dishes.dishes_name }</label>
		<label>${dishes.dishes_describe }</label>
		<label>${dishes.dishes_price }</label> 
		<img src='${pageContext.request.contextPath}/images/${dishes.photo }' width=136px height=80px />  
		<label>${dishes.dishes_cname }</label>
		<br>
	</c:forEach>

</body>
</html>