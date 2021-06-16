<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script language="JavaScript" type="text/javascript">
  function check(form) {
	var regu = /^[1-9]\d*$/;
	if(form.quantity.value=='') {
		alert("数量值不能为空!");
		form.quantity.focus();
		return false;
	}
	if(!regu.test(form.quantity.value)) {
		alert("必须输入整数!");
		form.quantity.focus();
		return false;
	}
  }
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
提交订单成功
<form name="myform" method='post' action='${pageContext.request.contextPath}/assess.do' >
<label>菜品id：<input type="text" name="id" placeholder="请输入菜品id"></label>
<label>星级评价：<input type="text" name="assessment" placeholder="请输入星级评价">星</label>
<label><input type="submit" name="submit" value="提交" onclick="return check(this.form)">
</label>
</form>
</body>
</html>