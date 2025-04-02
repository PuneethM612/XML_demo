package com.example.marksmgmt.controller;

import com.example.marksmgmt.model.ExamType;
import com.example.marksmgmt.model.Marks;
import com.example.marksmgmt.model.Student;
import com.example.marksmgmt.service.MarksService;
import com.example.marksmgmt.service.StudentService;
import com.example.marksmgmt.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * Controller for handling marks-related requests
 */
@Controller
public class MarksController {
    
    private MarksService marksService;
    private StudentService studentService;
    private SubjectService subjectService;
    
    public void setMarksService(MarksService marksService) {
        this.marksService = marksService;
    }
    
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    
    @GetMapping("/marks")
    public String listMarks(Model model) {
        model.addAttribute("marks", marksService.findAllMarks());
        return "marks/list";
    }
    
    @GetMapping("/marks/new")
    public String showNewMarksForm(Model model) {
        model.addAttribute("marks", new Marks());
        model.addAttribute("students", studentService.findAllStudents());
        model.addAttribute("subjects", subjectService.findAllSubjects());
        model.addAttribute("examTypes", ExamType.values());
        return "marks/form";
    }
    
    @GetMapping("/marks/edit/{id}")
    public String showEditMarksForm(@PathVariable Long id, Model model) {
        Marks marks = marksService.findMarksById(id);
        model.addAttribute("marks", marks);
        model.addAttribute("students", studentService.findAllStudents());
        model.addAttribute("subjects", subjectService.findAllSubjects());
        model.addAttribute("examTypes", ExamType.values());
        return "marks/form";
    }
    
    @PostMapping("/marks/save")
    public String saveMarks(@ModelAttribute Marks marks) {
        marksService.saveMarks(marks);
        return "redirect:/marks";
    }
    
    @GetMapping("/marks/delete/{id}")
    public String deleteMarks(@PathVariable Long id) {
        marksService.deleteMarksById(id);
        return "redirect:/marks";
    }
    
    @GetMapping("/marks/student/{id}")
    public String viewStudentMarks(@PathVariable Long id, Model model) {
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("marks", marksService.findMarksByStudent(student));
        return "marks/student";
    }
    
    @GetMapping("/marks/search")
    public String showSearchForm(Model model) {
        model.addAttribute("students", studentService.findAllStudents());
        model.addAttribute("examTypes", ExamType.values());
        return "marks/search";
    }
    
    @PostMapping("/marks/search")
    public String searchMarks(@RequestParam("studentId") Long studentId, 
                              @RequestParam("examType") ExamType examType,
                              Model model) {
        Student student = studentService.findStudentById(studentId);
        List<Marks> results = marksService.findMarksByStudentAndExamType(student, examType);
        
        model.addAttribute("student", student);
        model.addAttribute("examType", examType);
        model.addAttribute("results", results);
        return "marks/search-results";
    }
    
    @GetMapping("/ranks")
    public String showRanks(Model model) {
        model.addAttribute("examTypes", ExamType.values());
        return "marks/ranks";
    }
    
    @GetMapping("/ranks/{examType}")
    public String viewRanks(@PathVariable ExamType examType, Model model) {
        Map<Student, Double> topStudents = marksService.findTopStudentsByExamType(examType, 3);
        
        model.addAttribute("examType", examType);
        model.addAttribute("topStudents", topStudents);
        return "marks/ranks-results";
    }
} 