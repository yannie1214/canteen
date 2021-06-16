<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.hungry.beans.*" %>
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
  

<p style="font-size: 16px;  position: absolute; top:8.9%; left:48.5%;text-align: center;"><b>推荐菜品</b></p>
<div class="projects2">
    <!-- <br>
    <p style="font-size: 15px; height: 30px;width:300px;background-color: silver;padding: 0 0 0 20px;text-align: center;" >今日菜品</p> -->
    <ul class="rightborder">
        <!-- <p style="font-size: 16px;  background-color: rgb(0, 140, 255);text-align: center;">推荐菜品</p> -->
        <li class="instruct">
          <span style="padding:0px 65px 0 40px;position: relative ;top:25%;"><b>菜品图片</b> </span>
          <span style="padding:0px 100px 0 0;position: relative ;top:25%;"><b>菜品名称</b> </span>
          <span style="padding:0px 110px 0 30px;position: relative ;top:25%;"><b>菜品简介</b> </span>
          <span style="padding:0px 70px 0 0;position: relative ;top:25%;"><b>菜品金额（单点）</b> </span>
          <span style="padding:0px 100px 0 0;position: relative ;top:25%;"><b>菜品评价</b> </span>
          <span style="padding:0px 0px 0 0;position: relative ;top:25%;"><b>操作</b></span>
        </li>
        <% ArrayList<starAssessItem> starItemList = 
        (ArrayList<starAssessItem>)session.getAttribute("starItemList");
  %>
        <div class="cont">
     <% 
     // 对productList中每种商品循环
     for(starAssessItem saitem:starItemList){
      Dishes dishes=saitem.getDishes();  
     
  %>
  <form method='post' action='${pageContext.request.contextPath}/addToCart2.do' >
        <li class="dishes" id="first">
         <input type='hidden' name='id' value='<%=dishes.getDishes_id()%>'/>
                <img src="images/<%=dishes.getPhoto() %>" width=137px height=80px />
                <span id="one"><%=dishes.getDishes_name() %> </span>             
                <span id="two"><%=dishes.getDishes_describe() %></span>
                <span id="three"><%=dishes.getDishes_price() %>(元)</span>
                <span id="four"><%=saitem.getStarLevel() %>星</span>
                <span id="five">
                     <input type="submit" value='点餐' />
                        
                    </span>
                    
                
            </li>
             </form> 
              <%} %>
          
                      </div>

             
                     
    </ul>
    <script src="js/universial.js"></script>
</html>