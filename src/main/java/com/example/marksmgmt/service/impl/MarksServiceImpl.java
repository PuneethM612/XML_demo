package com.example.marksmgmt.service.impl;

import com.example.marksmgmt.model.ExamType;
import com.example.marksmgmt.model.Marks;
import com.example.marksmgmt.model.Student;
import com.example.marksmgmt.repository.MarksRepository;
import com.example.marksmgmt.service.MarksService;
import org.springframework.transaction.annotation.Transactional;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of MarksService
 */
public class MarksServiceImpl implements MarksService {
    
    private MarksRepository marksRepository;
    
    public void setMarksRepository(MarksRepository marksRepository) {
        this.marksRepository = marksRepository;
    }
    
    @Override
    @Transactional
    public Marks saveMarks(Marks marks) {
        return marksRepository.save(marks);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Marks findMarksById(Long id) {
        return marksRepository.findById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Marks> findAllMarks() {
        return marksRepository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Marks> findMarksByStudent(Student student) {
        return marksRepository.findByStudent(student);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Marks> findMarksByStudentAndExamType(Student student, ExamType examType) {
        return marksRepository.findByStudentAndExamType(student, examType);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Marks> findMarksByExamType(ExamType examType) {
        return marksRepository.findByExamType(examType);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Map<Student, Double> findTopStudentsByExamType(ExamType examType, int limit) {
        List<Object[]> results = marksRepository.findTopStudentsByExamType(examType, limit);
        Map<Student, Double> topStudents = new LinkedHashMap<>();
        
        for (Object[] result : results) {
            Student student = (Student) result[0];
            Double totalMarks = (Double) result[1];
            topStudents.put(student, totalMarks);
        }
        
        return topStudents;
    }
    
    @Override
    @Transactional
    public void deleteMarksById(Long id) {
        marksRepository.deleteById(id);
    }
} 