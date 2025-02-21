<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Assign Course</title>
</head>
<body>
    <h2>Assign Course to Faculty</h2>
    <form action="assign" method="post">
        <label>Faculty Email:</label>
        <input type="email" name="email" required>
        
        <label>Select Course:</label>
        <select name="courseId">
            <c:forEach var="course" items="${courses}">
                <option value="${course.id}">${course.name} - ${course.duration} months</option>
            </c:forEach>
        </select>
        <button type="submit">Assign Course</button>
    </form>
</body>
</html>
