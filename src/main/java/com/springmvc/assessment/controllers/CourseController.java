package com.springmvc.assessment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.assessment.beans.Course;
import com.springmvc.assessment.dao.CourseDao;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final CourseDao courseDao;

    @Autowired
    public CourseController(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @GetMapping("/add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "addCourse";
    }

    @PostMapping("/add")
    public String addCourse(@ModelAttribute("course") Course course) {
        courseDao.save(course);
        return "redirect:/courses/list"; // Redirect to the course list page
    }

    @GetMapping("/list")
    public String listCourses(Model model) {
        List<Course> courses = courseDao.getAllCourses();
        model.addAttribute("courses", courses);
        return "listCourses";
    }
}
