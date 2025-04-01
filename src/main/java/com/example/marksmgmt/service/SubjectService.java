package com.example.marksmgmt.service;

import com.example.marksmgmt.model.Subject;
import java.util.List;

/**
 * Service interface for handling Subject operations
 */
public interface SubjectService {
    
    /**
     * Save or update a subject
     * @param subject The subject to save
     * @return The saved subject
     */
    Subject saveSubject(Subject subject);
    
    /**
     * Find a subject by ID
     * @param id The subject ID
     * @return The found subject or null
     */
    Subject findSubjectById(Long id);
    
    /**
     * Find a subject by code
     * @param code The subject code
     * @return The found subject or null
     */
    Subject findSubjectByCode(String code);
    
    /**
     * Get all subjects
     * @return List of all subjects
     */
    List<Subject> findAllSubjects();
    
    /**
     * Delete a subject by ID
     * @param id The subject ID
     */
    void deleteSubjectById(Long id);
} 