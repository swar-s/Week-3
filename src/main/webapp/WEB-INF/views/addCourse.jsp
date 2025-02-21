<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Course</title>
</head>
<body>
    <h2>Add a New Course</h2>
    <form action="add" method="post">
        <label>Course Name:</label>
        <input type="text" name="name" required><br>

        <label>Duration (Months):</label>
        <input type="number" name="duration" required><br>

        <button type="submit">Add Course</button>
    </form>
    <a href="/courses/list">View All Courses</a>
</body>
</html>
