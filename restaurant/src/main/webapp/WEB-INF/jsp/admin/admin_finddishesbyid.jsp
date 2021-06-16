<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>菜品详情</title>
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
   <form action="${pageContext.request.contextPath }/tomodifydishes.do?id=${dish.getDishes_id()}
   &price=${dish.getDishes_price()}&name=${dish.getDishes_name()}&describe=${dish.getDishes_describe()}
   &photo=${dish.photo }&cname=${dish.getDishes_cname()}" method="POST">
		<div class="result-wrap">
            <div class="result-title">
                <h1>菜品详情</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">菜品ID</label>
                        <span class="res-info">${dish.getDishes_id()}</span>
                    </li>
                    <li>
                        <label class="res-lab">菜品价格</label>
                        <span class="res-info">${dish.getDishes_price()}</span>
                    </li>
                    <li>
                        <label class="res-lab">菜品名称</label>
                        <span class="res-info">${dish.getDishes_name()}</span>
                    </li>
                    <li>
                        <label class="res-lab">菜品描述</label>
                        <span class="res-info">${dish.getDishes_describe()}</span>
                    </li>
                    <li>
                        <label class="res-lab">菜系</label>
                        <span class="res-info">${dish.getDishes_cname()}</span>
                    </li>
                    <li>
                        <label class="res-lab">菜品图片</label>
                        <span class="res-info"><img src="${pageContext.request.contextPath }/images/${dish.photo }" width="150" height="150"></span>
                    </li>
                </ul>
                <tr>
                    <th></th>
                    <td>
                        <input class="btn btn-primary btn6 mr10" value="修改" type="submit">
                        <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                    </td>
                </tr>
            </div>
        </div>
   </form>
</body>
</html>