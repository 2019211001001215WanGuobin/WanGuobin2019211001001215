<%--
  Created by IntelliJ IDEA.
  User: zy
  Date: 2021/4/5
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if(request.getAttribute("message")!=null){
        out.println(request.getAttribute("message"));
    }
%>
<form method="post" action="${pageContext.request.contextPath}/login">
    <table>
        <tr> <td>Username:</td> <td><input type="text" name="username" required><br/></td></tr>
        <tr> <td>Password:</td> <td><input type="password" name="password" required minlength="8"><br/></td></tr>
        <tr> <td></td><td><input type="submit" value="Login"/></td>  </tr>
    </table>
</form>
<%@include file="footer.jsp"%>
