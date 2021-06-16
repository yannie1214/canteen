<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改信息</title>
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
<div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.do">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="dishes.do">菜品管理</a><span class="crumb-step">&gt;</span><span>修改菜品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
				<form action="${pageContext.request.contextPath }/modifydishes.do" method="post" enctype="multipart/form-data" >
				     <table class="insert-tab" width="100%">
				         <tbody>
				         	 <tr>
				                 <th><i class="require-red">*</i>菜品ID：</th>
				                 <td>
				                     <input class="common-text required" name="id" size="50" type="text" value="${param.id}" />
				                 </td>
				             </tr>
				             <tr>
				                 <th><i class="require-red">*</i>菜品价格：</th>
				                 <td>
				                     <input class="common-text required" name="price" size="50" type="text" value="${param.price}" />
				                 </td>
				             </tr>
				             <tr>
				                 <th><i class="require-red">*</i>菜品名称：</th>
				                 <td>
				                     <input class="common-text required" name="name" size="50" type="text" value="${param.name}" />
				                 </td>
				             </tr>
				             <tr>
					              <th width="120"><i class="require-red">*</i>菜系：</th>
					              <td>
					                  <select name="cname" class="required">
					                  <option value="">全部</option>
					                  <c:forEach var="cname" items="${list}">
								     		<option value="${cname.dishes_cname }">${cname.dishes_cname }</option>
								     </c:forEach> 
					                  </select>
					              </td>
					         </tr>
				         	 <tr>
				                 <th><i class="require-red">*</i>菜品描述：</th>
				                 <td>
				                     <input class="common-text required" name="describe" size="50" type="text" value="${param.describe}" />
				                 </td>
				             </tr>
				             <tr>
				                 <th><i class="require-red">*</i>图片：</th>
				                 <td><img src="${pageContext.request.contextPath }/images/${param.photo }" width="80" height="80">
										<input name="photo" size="50" type="file"></td>
				             </tr>
				             <tr>
				                 <th></th>
				                 <td>
				                     <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
				                     <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
				                 </td>
				             </tr>
				         </tbody>
				   </table>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>