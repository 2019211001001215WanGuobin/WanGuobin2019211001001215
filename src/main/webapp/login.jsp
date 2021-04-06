<%@include file="header.jsp" %>
Login <br>
<form method="post" action="${pageContext.request.contextPath}/login">
    <p>Username:<input type="text" name="name"/></p>

    <p>Password:<input type="password" name="password"/></p>
    <input type="submit" value="Login"/>
</form>
<%@include file="footer.jsp" %>
