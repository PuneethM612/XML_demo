package com.example.marksmgmt.service;

import com.example.marksmgmt.model.ExamType;
import com.example.marksmgmt.model.Marks;
import com.example.marksmgmt.model.Student;
import java.util.List;
import java.util.Map;

/**
 * Service interface for handling Marks operations
 */
public interface MarksService {
    
    /**
     * Save or update marks
     * @param marks The marks to save
     * @return The saved marks
     */
    Marks saveMarks(Marks marks);
    
    /**
     * Find marks by ID
     * @param id The marks ID
     * @return The found marks or null
     */
    Marks findMarksById(Long id);
    
    /**
     * Get all marks
     * @return List of all marks
     */
    List<Marks> findAllMarks();
    
    /**
     * Find marks by student
     * @param student The student
     * @return List of marks for the student
     */
    List<Marks> findMarksByStudent(Student student);
    
    /**
     * Find marks by student and exam type
     * @param student The student
     * @param examType The exam type
     * @return List of marks for the student and exam type
     */
    List<Marks> findMarksByStudentAndExamType(Student student, ExamType examType);
    
    /**
     * Find all marks by exam type
     * @param examType The exam type
     * @return List of marks for the exam type
     */
    List<Marks> findMarksByExamType(ExamType examType);
    
    /**
     * Get top students by total marks and exam type
     * @param examType The exam type
     * @param limit The number of top students to return
     * @return Map of students and their total marks, ordered by rank
     */
    Map<Student, Double> findTopStudentsByExamType(ExamType examType, int limit);
    
    /**
     * Delete marks by ID
     * @param id The marks ID
     */
    void deleteMarksById(Long id);
} 