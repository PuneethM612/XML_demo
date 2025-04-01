package com.example.marksmgmt.repository;

import com.example.marksmgmt.model.Subject;
import java.util.List;

/**
 * Repository interface for Subject entity
 */
public interface SubjectRepository {
    
    /**
     * Save or update a subject
     * @param subject The subject to save
     * @return The saved subject
     */
    Subject save(Subject subject);
    
    /**
     * Find a subject by ID
     * @param id The subject ID
     * @return The found subject or null
     */
    Subject findById(Long id);
    
    /**
     * Find a subject by code
     * @param code The subject code
     * @return The found subject or null
     */
    Subject findByCode(String code);
    
    /**
     * Get all subjects
     * @return List of all subjects
     */
    List<Subject> findAll();
    
    /**
     * Delete a subject by ID
     * @param id The subject ID
     */
    void deleteById(Long id);
} 