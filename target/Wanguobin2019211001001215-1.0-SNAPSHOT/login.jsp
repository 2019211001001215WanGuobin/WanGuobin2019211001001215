<%@ page contentType="text/html; ISO-8859-1ml;charset=UTF-8" language="java" %>
<html>
        <%@include file="WEB-INF/views/header.jsp"%>
    <body>
        <h2>Login</h2>
        <%
            if(!(request.getAttribute("message")==null)) {
                out.println("<h3>"+request.getAttribute("message")+"<h3>");
            }
        %>
        <form action="login" method="post">
            Username:<input type="text" id="username" name="username"><br>
            Password:<input type="password" id="password" name="password"><br>
            <input type="submit" value="login">
        </form>
    </body>
        <%@ include file="WEB-INF/views/footer.jsp"%>
    </html>
