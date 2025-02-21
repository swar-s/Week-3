package com.springmvc.assessment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.assessment.beans.Course;

public class CourseDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Course course) {
        String query = "INSERT INTO courses (name, duration) VALUES (?, ?)";
        return jdbcTemplate.update(query, course.getName(), course.getDuration());
    }

    public List<Course> getAllCourses() {
        String query = "SELECT * FROM courses";
        return jdbcTemplate.query(query, new RowMapper<Course>() {
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Course(rs.getInt("id"), rs.getString("name"), rs.getInt("duration"));
            }
        });
    }
}
