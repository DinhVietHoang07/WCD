<%@ page import="com.t2010a.hellot2010aagain.entity.Student" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Student student = (Student)request.getAttribute("student");
%>
<jsp:include page="../includes/header.jsp">
    <jsp:param name="title" value="${student.getFullName()} | Student detail"/>
</jsp:include>
<jsp:include page="../includes/menu.jsp"></jsp:include>
    <a href="/admin/students/list">Back to list</a> &nbsp;
    <a href="/admin/students/create">Create new student</a>
    <div>
        Rollnumber: <%=student.getRollNumber()%>
    </div>
    <div>
        Fullname: <%=student.getFullName()%>
    </div>
<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>
