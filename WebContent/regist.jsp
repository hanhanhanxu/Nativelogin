<%@page import="cn.itcast.Dao.impl.UserDaoJdbcImpl"%>
<%@page import="cn.itcast.domain.User"	%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String account = request.getParameter("account");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String email = request.getParameter("email");
	
	User user = new User(account,password,name,age,email);
	new UserDaoJdbcImpl().add(user);
	
	out.write("注册成功");
%>
</body>
</html>