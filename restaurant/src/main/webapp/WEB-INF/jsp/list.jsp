<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>有点饿订餐系统</title>
    <link href="${pageContext.request.contextPath}/css/style1.css"  rel="stylesheet"  media="screen"  type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/carts.css">
    <script src="/META-INF/resources/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.dialog.js"></script>
    <script src="${pageContext.request.contextPath}/js/carts.js"></script>
    <script src="${pageContext.request.contextPath}/js/universial.js"></script>
    <style type="text/css">a {text-decoration: none}</style>
  </head>
  <div>     
	<div class="nav_bg"><%@ include file="inner/head.jsp" %></div>
	 <div class="left" ><%@ include file="inner/left.jsp" %></div>
  </div>
 
	<div class="projects"><%@ include file="inner/content.jsp" %></div>
  <div class="footer"><%@ include file="inner/footer.jsp" %></div>
</html>