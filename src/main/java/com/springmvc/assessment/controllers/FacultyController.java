package com.springmvc.assessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.assessment.beans.Course;
import com.springmvc.assessment.beans.Faculty;
import com.springmvc.assessment.dao.FacultyDao;

@Controller
@RequestMapping("/faculty")
public class FacultyController
{
	private final FacultyDao facultyDao;

    @Autowired
    public FacultyController(FacultyDao facultyDao) {
        this.facultyDao = facultyDao;
    }
    
    @GetMapping("/assessment")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("message", "Welcome to Faculty Management");
        return mv;
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("faculty") Faculty faculty) {
        facultyDao.save(faculty);
        return "redirect:/faculty/login";
    }
    
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("faculty", new Faculty());
        return "register";
    }
    
    @GetMapping("/assign")
    public String showAssignCourseForm(Model model) {
        List<Course> courses = facultyDao.getAllCourses();
        model.addAttribute("courses", courses);
        return "assignCourse";
    }
    
    @PostMapping("/assign")
    public String assignCourse(@RequestParam String email, @RequestParam int courseId) {
        Faculty faculty = facultyDao.getFacultyByEmail(email);
        if (faculty != null) {
            facultyDao.assignCourseToFaculty(faculty.getId(), courseId);
        }
        return "redirect:/faculty/dashboard";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        Faculty faculty = facultyDao.getFacultyByEmail(email);
        if (faculty != null && faculty.getPassword().equals(password)) {
            model.addAttribute("faculty", faculty);
            return "dashboard";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }
}