package com.example.marksmgmt.service;

import com.example.marksmgmt.model.Student;
import java.util.List;

/**
 * Service interface for handling Student operations
 */
public interface StudentService {
    
    /**
     * Save or update a student
     * @param student The student to save
     * @return The saved student
     */
    Student saveStudent(Student student);
    
    /**
     * Find a student by ID
     * @param id The student ID
     * @return The found student or null
     */
    Student findStudentById(Long id);
    
    /**
     * Find a student by roll number
     * @param rollNumber The roll number
     * @return The found student or null
     */
    Student findStudentByRollNumber(String rollNumber);
    
    /**
     * Get all students
     * @return List of all students
     */
    List<Student> findAllStudents();
    
    /**
     * Delete a student by ID
     * @param id The student ID
     */
    void deleteStudentById(Long id);
} 