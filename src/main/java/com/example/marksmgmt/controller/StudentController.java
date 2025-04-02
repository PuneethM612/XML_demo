package com.example.marksmgmt.controller;

import com.example.marksmgmt.model.Student;
import com.example.marksmgmt.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling student-related requests
 */
@Controller
public class StudentController {
    
    private StudentService studentService;
    
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.findAllStudents());
        return "students/list";
    }
    
    @GetMapping("/students/new")
    public String showNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/form";
    }
    
    @GetMapping("/students/edit/{id}")
    public String showEditStudentForm(@PathVariable Long id, Model model) {
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "students/form";
    }
    
    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
    
    @GetMapping("/students/view/{id}")
    public String viewStudent(@PathVariable Long id, Model model) {
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "students/view";
    }
} 