package com.example.marksmgmt.controller;

import com.example.marksmgmt.model.Subject;
import com.example.marksmgmt.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling subject-related requests
 */
public class SubjectController {
    
    private SubjectService subjectService;
    
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    
    @GetMapping("/subjects")
    public String listSubjects(Model model) {
        model.addAttribute("subjects", subjectService.findAllSubjects());
        return "subjects/list";
    }
    
    @GetMapping("/subjects/new")
    public String showNewSubjectForm(Model model) {
        model.addAttribute("subject", new Subject());
        return "subjects/form";
    }
    
    @GetMapping("/subjects/edit/{id}")
    public String showEditSubjectForm(@PathVariable Long id, Model model) {
        Subject subject = subjectService.findSubjectById(id);
        model.addAttribute("subject", subject);
        return "subjects/form";
    }
    
    @PostMapping("/subjects/save")
    public String saveSubject(@ModelAttribute Subject subject) {
        subjectService.saveSubject(subject);
        return "redirect:/subjects";
    }
    
    @GetMapping("/subjects/delete/{id}")
    public String deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubjectById(id);
        return "redirect:/subjects";
    }
    
    @GetMapping("/subjects/view/{id}")
    public String viewSubject(@PathVariable Long id, Model model) {
        Subject subject = subjectService.findSubjectById(id);
        model.addAttribute("subject", subject);
        return "subjects/view";
    }
} 