package com.example.marksmgmt.model;

import java.io.Serializable;

/**
 * Model class representing marks obtained by a student in a subject
 */
public class Marks implements Serializable {
    
    private Long id;
    private Student student;
    private Subject subject;
    private ExamType examType;
    private Double marks;
    
    // Default constructor
    public Marks() {
    }
    
    // Constructor with fields
    public Marks(Student student, Subject subject, ExamType examType, Double marks) {
        this.student = student;
        this.subject = subject;
        this.examType = examType;
        this.marks = marks;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    public Subject getSubject() {
        return subject;
    }
    
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    
    public ExamType getExamType() {
        return examType;
    }
    
    public void setExamType(ExamType examType) {
        this.examType = examType;
    }
    
    public Double getMarks() {
        return marks;
    }
    
    public void setMarks(Double marks) {
        this.marks = marks;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Marks marks = (Marks) o;
        
        return id != null ? id.equals(marks.id) : marks.id == null;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    
    @Override
    public String toString() {
        return "Marks{" +
                "id=" + id +
                ", student=" + (student != null ? student.getRollNumber() : null) +
                ", subject=" + (subject != null ? subject.getCode() : null) +
                ", examType=" + examType +
                ", marks=" + marks +
                '}';
    }
} 