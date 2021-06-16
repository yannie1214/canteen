<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
    <form class="search" action="${pageContext.request.contextPath }/findByWord.do" method="post">
		  		     <input class="input_text" type="text" name="word" placeholder="请搜索...">
		  		    <input type="submit" name="button" value="搜索" class="input_sub">
		  		  </form>
              <ul class="leftborder">
              
                <li class="border1">
                  <a href="myorder.jsp">
                      <img src='${pageContext.request.contextPath}/images/dingdan.png' width=14 height=14 />
                      <span class="outer">  我的订单</span>
                      <br>
                      <br>
                      <span class="inner">近三个月的订单</span>
                      
                  </a>
              </li>
              <li class="border2clicked">
                  <a href="${pageContext.request.contextPath}/showAll.do">
                      <img src='${pageContext.request.contextPath}/images/remaicaipin.png' width=14 height=14 />
                      <span class="outer">当天菜品</span>
                      
                  </a>
              </li>
              <li class="border3">
                  <a href="${pageContext.request.contextPath}/recommend.do">
                      <img src='${pageContext.request.contextPath}/images/tuijian.png' width=14 height=14 />
                      <span class="outer">推荐菜品</span>
                  </a>
              </li>
              <li class="border5">
                      <a href="${pageContext.request.contextPath}/showCart.do">
                          <img src='${pageContext.request.contextPath}/images/today.png' width=14 height=14 />
                          <span class="outer">已选菜品</span>    
                      </a>
              </li>
                <li class="border4">
                  <c:forEach items="${category_list}" var="category" >
                  <a href="${pageContext.request.contextPath}/showType.do?dishes_cname=${category.dishes_cname}">
                  	<img src='${pageContext.request.contextPath}/images/menu.png' width=14 height=14 />
                      <span class="outer">${category.dishes_cname}</span></a>
                      <br><br>
                  </c:forEach>            
                  
              </li>    
                           
              </ul>
