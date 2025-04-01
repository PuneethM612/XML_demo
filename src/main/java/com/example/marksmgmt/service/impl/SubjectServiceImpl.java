package com.example.marksmgmt.service.impl;

import com.example.marksmgmt.model.Subject;
import com.example.marksmgmt.repository.SubjectRepository;
import com.example.marksmgmt.service.SubjectService;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Implementation of SubjectService
 */
public class SubjectServiceImpl implements SubjectService {
    
    private SubjectRepository subjectRepository;
    
    public void setSubjectRepository(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }
    
    @Override
    @Transactional
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Subject findSubjectById(Long id) {
        return subjectRepository.findById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Subject findSubjectByCode(String code) {
        return subjectRepository.findByCode(code);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }
    
    @Override
    @Transactional
    public void deleteSubjectById(Long id) {
        subjectRepository.deleteById(id);
    }
} 