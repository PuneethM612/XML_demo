package com.example.marksmgmt.repository;

import com.example.marksmgmt.model.ExamType;
import com.example.marksmgmt.model.Marks;
import com.example.marksmgmt.model.Student;
import java.util.List;

/**
 * Repository interface for Marks entity
 */
public interface MarksRepository {
    
    /**
     * Save or update marks
     * @param marks The marks to save
     * @return The saved marks
     */
    Marks save(Marks marks);
    
    /**
     * Find marks by ID
     * @param id The marks ID
     * @return The found marks or null
     */
    Marks findById(Long id);
    
    /**
     * Get all marks
     * @return List of all marks
     */
    List<Marks> findAll();
    
    /**
     * Find marks by student
     * @param student The student
     * @return List of marks for the student
     */
    List<Marks> findByStudent(Student student);
    
    /**
     * Find marks by student and exam type
     * @param student The student
     * @param examType The exam type
     * @return List of marks for the student and exam type
     */
    List<Marks> findByStudentAndExamType(Student student, ExamType examType);
    
    /**
     * Find all marks by exam type
     * @param examType The exam type
     * @return List of marks for the exam type
     */
    List<Marks> findByExamType(ExamType examType);
    
    /**
     * Get top students by total marks and exam type
     * @param examType The exam type
     * @param limit The number of top students to return
     * @return List of top students with their total marks
     */
    List<Object[]> findTopStudentsByExamType(ExamType examType, int limit);
    
    /**
     * Delete marks by ID
     * @param id The marks ID
     */
    void deleteById(Long id);
} 