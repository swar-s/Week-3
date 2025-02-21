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
    <c:choose>
        <c:when test="${empty faculty.courses}">
            <p>No courses assigned yet.</p>
        </c:when>
        <c:otherwise>
            <table border="1">
                <tr>
                    <th>Course Name</th>
                    <th>Duration (Months)</th>
                </tr>
                <c:forEach var="course" items="${faculty.courses}">
                    <tr>
                        <td>${course.name}</td>
                        <td>${course.duration}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>

    <h3>Actions</h3>
    <ul>
        <li><a href="/courses/list">View All Courses</a></li>
        <li><a href="/faculty/assign">Assign Courses</a></li>
        <li><a href="/Logout">Logout</a></li>
    </ul>

</body>
</html>
