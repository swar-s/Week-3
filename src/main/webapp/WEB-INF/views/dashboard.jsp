<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Faculty Dashboard</title>
</head>
<body>
    <h2>Welcome, ${faculty.name}!</h2>
    <p>Email: ${faculty.email}</p>
    <p>Mobile: ${faculty.mobile}</p>
    <h3>Assigned Courses</h3>
    <ul>
        <c:forEach var="course" items="${faculty.courses}">
            <li>${course.name} - ${course.duration} months</li>
        </c:forEach>
    </ul>
    <a href="/Logout">Logout</a>
</body>
</html>
