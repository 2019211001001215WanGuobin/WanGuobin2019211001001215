<%--
  Created by IntelliJ IDEA.
  User: 1531560506
  Date: 2021/3/14
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>New User Registration</p>
<form method="post"  action="register">
    UserName :<input type="text" name="Username"><br/>
    Password :<input type="text" name="Password"><br/>
    Email :<input type="text" name="Email"><br/>
    Gender:<input type="radio" name="gender" value="male">Male<input type="radio" name="gender" value="female">Female<br/>
    Date of birth :<input type="text" name="birthDate"><br/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
