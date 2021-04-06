<%--
  Created by IntelliJ IDEA.
  User: 1531560506
  Date: 2021/3/14
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
</head>
<body>
<%--<a href="index.jsp">go to ECJTU</a>
<form method="get">
    Name :<input type="text" name="name"><br/>
    ID :<input type="text" name="id"><br/>
    <input type="submit" value="Send data to server"/>
</form>--%>
<%@include file="header.jsp" %>
This is my JSP page. <br>
<br/>
<%@include file="footer.jsp" %>
</body>
</html>