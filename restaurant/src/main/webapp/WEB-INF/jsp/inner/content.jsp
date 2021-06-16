<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <ul class="rightborder">
          <p style="font-size: 16px; text-align: center;">菜品</p>
          <li class="instruct">
            <span style="padding:0px 65px 0 40px;position: relative ;top:25%;"><b>菜品图片</b> </span>
            <span style="padding:0px 100px 0 0;position: relative ;top:25%;"><b>菜品名称</b> </span>
            <span style="padding:0px 110px 0 0;position: relative ;top:25%;"><b>菜品简介</b> </span>
            <span style="padding:0px 70px 0 30px;position: relative ;top:25%;"><b>菜品金额（单点）</b> </span>
            <span style="padding:0px 100px 0 0;position: relative ;top:25%;"><b>菜品评价</b> </span>
            <span style="padding:0px 0px 0 0;position: relative ;top:25%;"><b>操作</b></span>
          </li>
          <div class="cont">

          <div class="cont">
     
   <c:forEach items="${list }" var="dish">
   <form name="myform" method='post' action='${pageContext.request.contextPath}/addToCart.do' >
          <li class="dishes" id="first">
          <input type='hidden' name='id' value='${dish.dishes_id }'/>
          <img src='${pageContext.request.contextPath}/images/${dish.photo }' width=136px height=80px />  
              <span id="one">${dish.dishes_name }</span>          
              <span id="two">${dish.dishes_describe }</span>
              <span id="three">${dish.dishes_price }</span>
              <span id="four">9星</span>
              <span id="five">
              
                  <!-- <button class="inn" id="order1">点餐</button> -->
                  <input type="submit" value='点餐' 
                      onclick="return check(this.form)"/>
              </span>
              <span id="six">
                      <button class="inn" id="evaluate1">菜品评价</button>
              </span>
              
          </li></form>
       </c:forEach>
         </div>
                                               
      </ul>
