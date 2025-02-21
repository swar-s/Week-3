package com.springmvc.assessment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.assessment.beans.Course;
import com.springmvc.assessment.beans.Faculty;

public class FacultyDao
{
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int save(Faculty faculty)
	{
		String query = "INSERT INTO faculty (name, email, password, mobile) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(query, faculty.getName(), faculty.getEmail(), faculty.getPassword(), faculty.getMobile());
	}
	
	public void assignCourseToFaculty(int facultyId, int courseId) {
	    String query = "INSERT INTO faculty_courses (faculty_id, course_id) VALUES (?, ?)";
	    jdbcTemplate.update(query, facultyId, courseId);
	}
	
	private List<Course> getCoursesByFacultyId(int facultyId) {
	    String query = "SELECT c.id, c.name, c.duration FROM course c " +
	                   "JOIN faculty_courses fc ON c.id = fc.course_id " +
	                   "WHERE fc.faculty_id = ?";
	    return jdbcTemplate.query(query, new RowMapper<Course>() {
	        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
	            return new Course(rs.getInt("id"), rs.getString("name"), rs.getInt("duration"));
	        }
	    }, facultyId);
	}
	
	public List<Course> getAllCourses() {
	    String query = "SELECT * FROM course";
	    return jdbcTemplate.query(query, new RowMapper<Course>() {
	        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
	            return new Course(rs.getInt("id"), rs.getString("name"), rs.getInt("duration"));
	        }
	    });
	}

	
	public Faculty getFacultyByEmail(String email) {
        String query = "SELECT * FROM faculty WHERE email = ?";
        return jdbcTemplate.queryForObject(query, new RowMapper<Faculty>() {
            public Faculty mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Faculty(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getString("mobile"), getCoursesByFacultyId(rs.getInt("id")));
            }
        }, email);
    }
	
	public List<Faculty> getAllFaculties() {
        return jdbcTemplate.query("SELECT * FROM faculty", new RowMapper<Faculty>() {
            public Faculty mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Faculty(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getString("mobile"), getCoursesByFacultyId(rs.getInt("id")));
            }
        });
    }

}