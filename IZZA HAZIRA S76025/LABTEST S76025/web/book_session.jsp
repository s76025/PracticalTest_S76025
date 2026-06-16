<%-- 
    Document   : book_session
    Created on : 16 Jun 2026, 3:51:19 PM
    Author     : MP2-4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book A Training Session</title>
    </head>
    <body>
        <h1>Book A Training Session</h1>

        <form action ="BookSessionServlet" method="POST">
            <input type="hidden" name="action" value="booking">
            Student Name: <input type="text" name="studentName" required><br><br>
            Branch Location: <input type="text" name="brancLocation" required><br><br>
            Lesson Type: <input type="text" name="lessonType" required><br><br>
            <br>
            <br>
            <input type="submit" value="Book">
        </form>
        
    </body>
</html>
