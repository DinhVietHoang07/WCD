<%@ page import="com.t2010a.hellot2010aagain.entity.Account" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Account account = (Account) session.getAttribute("account");
%>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>User information</h1>
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
