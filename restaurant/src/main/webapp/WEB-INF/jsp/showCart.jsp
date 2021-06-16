<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.hungry.beans.*" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <p style="font-size: 16px;  position: absolute; top:8.9%; left:48.5%;text-align: center;"><b>已选菜品</b></p>
  <div class="projects">
      <!-- <br>
      <p style="font-size: 15px; height: 30px;width:300px;background-color: silver;padding: 0 0 0 20px;text-align: center;" >今日菜品</p> -->
       <%--   <form action="${pageContext.request.contextPath }/saveOrder.do" method="post" id="form"> --%>
      <ul class="rightborder">
          <li class="instruct">
            <span style="padding:0px 65px 0 40px;position: relative ;top:25%;"><b>菜品图片</b> </span>
            <span style="padding:0px 110px 0 0;position: relative ;top:25%;"><b>菜品名称</b> </span>
            <span style="padding:0px 110px 0 0;position: relative ;top:25%;"><b>菜品价格</b> </span>
            <span style="padding:0px 110px 0 30px;position: relative ;top:25%;"><b>小计</b> </span>
            <span style="padding:0px 0px 0 0;position: relative ;top:25%;"><b>数量</b></span>
            <span style="padding:0px 0px 0 0;position: relative ;top:25%;"><b></b></span>
          </li>
   <% ArrayList<DishesItem> diList = 
        (ArrayList<DishesItem>)session.getAttribute("diList");
  %>
  <div class="cont">
  <% 
     // 对productList中每种商品循环
       double total=0;
     for(DishesItem dishesitem:diList){
      Dishes dishes=dishesitem.getDishes();  
     
  %>
          <li class="dishes" id="first">
              <img src="images/<%=dishes.getPhoto()%>" width=136px height=80px />
              <span id="one"><%=dishes.getDishes_name()%> </span>          
              <span id="two"><%=dishes.getDishes_price()%></span>
              <span id="three"><%=dishes.getDishes_cname()%></span>
              <span id="four"><%=dishesitem.getQuantity()%> </span>
              <span id="five">
              <a href="${pageContext.request.contextPath}/addQuantity.do?id=<%=dishes.getDishes_id()%>"><button>增加</button></a>
              
          
               <a href="${pageContext.request.contextPath}/declineQuantity.do?id=<%=dishes.getDishes_id()%>"><button>减少</button></a>
              <!-- </span>
              <span id="seven"> -->
               <%=((double)(dishes.getDishes_price()* dishesitem.getQuantity()))%>
               <%total=total+(double)(dishes.getDishes_price()* dishesitem.getQuantity());  %>
              </span>
              <a href="${pageContext.request.contextPath }/saveOrder.do?totalAmount=<%=((double)(dishes.getDishes_price()* dishesitem.getQuantity()))%>&dishesInfo=<%=dishesitem.getQuantity()%>_<%=dishes.getDishes_id()%>">提交</a>
        </div>
          </li>
      <%} %>
  
                  
  </div>
        <%--   <c:forEach items="${diList}" var="diList">
          <li class="dishes" id="first">
          <img src='${pageContext.request.contextPath}/images/${diList.dishes.photo }' width=136px height=80px />  
              <span id="one">${diList.dishes.dishes_name }</span>          
              
              <span id="two">${diList.dishes.dishes_price }</span>
              <span id="three">${ diList.dishes.price*diList.Quantity }</span>
              <span id="four">${diList.Quantity } </span>      
          </li>
          </c:forEach>
                     
      </ul> --%>
      <%-- <%--  <img src='${pageContext.request.contextPath}/images/<%=dishes.getPhoto()%>' width=136px height=80px />
              <span id="one"><%=dishes.getDishes_name()%> </span>          
              <span id="two"><%=dishes.getDishes_price()%></span>
              <span id="three"><%=((double)(dishes.getDishes_price()* dishesitem.getQuantity()))%></span>
              <span id="four"><%=dishesitem.getQuantity()%> </span>
              <span id="five">
              <a href="${pageContext.request.contextPath}/addQuantity.do?id=<%=dishes.getDishes_id()%>"><button>增加</button></a>
              <a href="${pageContext.request.contextPath}/declineQuantity.do?id=<%=dishes.getDishes_id()%>"><button>减少</button></a>
              </span> --%>
            
			<!-- 存放商品id -->
			<!-- <input name="article_id" id="article_id"/> -->
			<!-- 存放商品购买的数量 和id-->
			<%-- <input type="hidden" name="articleInfo" id="articleInfo" value="${item.dishes.dishes_id }#${item.Quantity}"/> --%>
     <%--  <% double totalAmount=(double)(${item.dishes.price*item.Quantity });%> --%>
      <%-- 	<a href="${pageContext.request.contextPath }/saveOrder.do?totalAmount=${diList.dishes.price*diList.Quantity }&dishesInfo=#${diList.Quantity}#${diList.dishes.dishes_id }">提交</a> --%>

  </div>
   <script src="js/universial.js"></script>
<!--底部-->
  <%--   <div class="bar-wrapper">
        <div class="bar-right">
            <div class="piece">已选商品<strong class="piece_num"><%=diList.size() %>件</div>
            <div class="totalMoney">共计: <strong class="total_text"><%=total %></div>
         
    </div> --%>
<br>

</body>
</html>