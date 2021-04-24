<%@ page import="com.WanGuobin.model.User" %><%--
  Created by IntelliJ IDEA.
  User: zy
  Date: 2021/4/11
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<%User User= (User) session.getAttribute("user");%>
<body>
<h3>
    User Info
</h3>
<table >
    <tr><td>Username:</td><td><%=User.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=User.getPassword()%></td></tr>
    <tr><td>Gender:</td><td><%=User.getGender()%></td></tr>
    <tr><td>Email:</td><td><%=User.getEmail()%></td></tr>
    <tr><td>Birthdate:</td><td><%=User.getBirthdate()%></td></tr>
    <tr><td><a href="updateUser">Update User</a></td></tr>

</table>
</body>
</html>
<%@include file="footer.jsp"%>

