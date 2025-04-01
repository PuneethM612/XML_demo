package com.example.marksmgmt.repository;

import com.example.marksmgmt.model.Student;
import java.util.List;

/**
 * Repository interface for Student entity
 */
public interface StudentRepository {
    
    /**
     * Save or update a student
     * @param student The student to save
     * @return The saved student
     */
    Student save(Student student);
    
    /**
     * Find a student by ID
     * @param id The student ID
     * @return The found student or null
     */
    Student findById(Long id);
    
    /**
     * Find a student by roll number
     * @param rollNumber The roll number
     * @return The found student or null
     */
    Student findByRollNumber(String rollNumber);
    
    /**
     * Get all students
     * @return List of all students
     */
    List<Student> findAll();
    
    /**
     * Delete a student by ID
     * @param id The student ID
     */
    void deleteById(Long id);
} 