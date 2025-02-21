<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Available Courses</title>
</head>
<body>
    <h2>All Available Courses</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Course Name</th>
            <th>Duration (Months)</th>
        </tr>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.id}</td>
                <td>${course.name}</td>
                <td>${course.duration}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/courses/add">Add New Course</a>
</body>
</html>
