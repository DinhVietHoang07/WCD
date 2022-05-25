<%@ page import="com.t2010a.hellot2010aagain.controller.Account" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/19/2022
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Account account = (Account) session.getAttribute("account");
%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1> User information</h1>
<div>
    Username <%=account.getUsername()%>
</div>
<div>
    Password <%=account.getPassword()%>
</div>
<div>
    Email <%=account.getEmail()%>
</div>
<div>
    Phone <%=account.getPhone()%>
</div>
</body>
</html>
