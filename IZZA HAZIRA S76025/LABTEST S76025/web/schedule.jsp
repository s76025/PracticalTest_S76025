<%-- 
    Document   : schedule
    Created on : 16 Jun 2026, 3:58:13 PM
    Author     : MP2-4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>centralized Schedule</title>
    </head>
    <body>
        <%@ include file= "header.html" %>
        <h1>centralized Schedule</h1>
        <table border ="1" cellpadding="8">
            <thead>
                <tr>
                    <th>Student Name</th>
                    <th>Branch Location</th>
                    <th>Lesson Type</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="employee"
                       items="${listSessions}">
                <tr>
                    <td><c:out value="${employee.id}"
                           /></td>
                <td><c:out value="${student_name}"
                           /></td>
                <td><c:out value="${branch_location}"
                           /></td>
                <td><c:out value=
                           "${lesson_type}" /></td>
                <td>
                    <a href="edit?id=<c:out value=
                       '${employee.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value=
                       '${employee.id}' />">Delete</a>
                </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
                <%@ include file= "footer.jsp" %>        
</body>
</html>
