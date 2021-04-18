<%@page  contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="header.jsp" %>
<h2>User Info</h2>

<table border="1" >
    <tr>
        <td>username</td><td><%=request.getAttribute("username")%></td> </tr>
        <td>password</td><td><%=request.getAttribute("password")%></td> </tr>
        <td>email</td> <td><%=request.getAttribute("email")%></td> </tr>
        <td>gender</td><td><%=request.getAttribute("gender")%></td> </tr>
        <td>birthdate</td> <td><%=request.getAttribute("birthdate")%></td>
    </tr>
</table>
<%@include file="footer.jsp" %>
