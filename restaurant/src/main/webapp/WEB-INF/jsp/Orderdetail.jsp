<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单详情页面</title>
</head>
<body>
<br>
	 <table id="table" border="1" cellspacing="0" cellpadding="0" >
               
               <c:forEach var="order" items="${orders }">
               
                <thead>
                    <tr style="background-color:green">
                       
                        <th style="width: 25%">订单号</th>
                        <th style="width: 25%">下单时间</th>
                        <th style="width: 15%">发货时间</th>
                        <th style="width: 10%">订单状态</th>
                        <th style="width: 15%">订单总金额</th>
                    </tr>
                </thead>
                <tbody>
                	<tr>
                	<td>
                		${order.order_code }
                	  </td>
                	<td>
                		<fmt:formatDate value="${order.create_date}" pattern="yyyy年MM月dd日 HH:mm:ss"/>
                	  </td>
                	<td>
                		<fmt:formatDate value="${order.send_date}" pattern="yyyy年MM月dd日 HH:mm:ss"/>
                	  </td>
                	<td>
                		${order.status ==0 ? '未发货' : '已发货'}
                	  </td>
                	<td>
                		${order.amount }
                	  </td>
                </tr>
                </tbody>
                <c:forEach items="${order.items }" var="item">
                <thead>
                    <tr>
                       
                        <th style="width: 25%">图片</th>
                        <th style="width: 25%">名称</th>
                        <th style="width: 15%"">价格</th>
                        <th style="width: 10%">数量</th>
                        <th style="width: 7%">操作</th>
                    </tr>
                </thead>
                <tbody>
                	<tr>
                	<td>
                	 <img alt="商品图片" width="300" height="300" src="${pageContext.request.contextPath}/images/${item.dishes.photo}">
                	</td>
                	<td>
                	  ${item.dishes.dishes_name }
                	</td>
                	<td>
                	${item.dishes.dishes_price }
                	</td>
                	<td>
                	${item.order_num }
                	</td>
                	<td>
                	<form method='post' action='${pageContext.request.contextPath}/assess.do' >
<input type="hidden" name="id" value="${item.dishes.dishes_id}">
<input type="text" name="assessment" placeholder="请输入星级评价">星
<input type="submit" name="submit" value="提交" >

</form>
                </tbody>
                
                </c:forEach>
                </c:forEach>
                </table>
</body>
</html>