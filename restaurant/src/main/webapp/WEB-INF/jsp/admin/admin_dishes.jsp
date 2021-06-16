<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>菜品管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css"/>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="${pageContext.request.contextPath }/index.do" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="${pageContext.request.contextPath }/index.do">首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="${pageContext.request.contextPath }/index.do">管理员</a></li>
                <li><a href="#">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="${pageContext.request.contextPath }/index.do"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="dishes.do"><i class="icon-font">&#xe008;</i>菜品管理</a></li>
                        <li><a href="cate.do"><i class="icon-font">&#xe005;</i>分类管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
<%-- <%@include file="admin_menu.jsp" %> --%>
<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">菜品管理</span></div>
     </div>
     <div class="search-wrap">
        <div class="search-content">
           <form action="#" method="post">
                    <table class="search-tab">
                        <tr>
                        <th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="">全部</option>
                                    <c:forEach var="cname" items="${clist}">
					               		<option value="${cname.dishes_cname }">${cname.dishes_cname }</option>
					               </c:forEach> 
                                </select>
                            </td>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform"1 id="myform1" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="toadddishes.do"><i class="icon-font"></i>新增菜品</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>ID</th>
				            <th>菜品价格</th>
				            <th>菜品名称</th>
				            <th>菜品描述</th>
				            <th>菜系</th>
				            <th>操作</th>
                        </tr>
                        <tr>
                        	<c:forEach var="list" items="${list}">
							  <tr>
								<th>${list.dishes_id }</th>
						        <th>${list.dishes_price }</th>
						        <th><img src="${pageContext.request.contextPath }/images/${list.photo }" width="80" height="80">
						        ${list.dishes_name }</th>
						        <th>${list.dishes_describe }</th>
						        <th>${list.dishes_cname}</th>
						        <th><a href="finddishesbyid.do?id=${list.dishes_id}">修改</a>&nbsp;&nbsp;
						        <a href="finddishesbyid.do?id=${list.dishes_id}">商品详情</a>&nbsp;&nbsp;
						        <a href="javascript:removeDishes(${list.dishes_id })">删除</a></th>
						   	  </tr>
						   </c:forEach>
                        </tr>
                        <script>
                        function removeDishes(id){
                            if(confirm("你确定要删除该菜品吗")){
                                 location.href="removedishes.do?id="+id;
                            }
                       }
					   </script>
                    </table>
                </div>
            </form>
        </div>
     </div>
</div>
</body>
</html>