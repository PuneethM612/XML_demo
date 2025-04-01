package com.example.marksmgmt.service.impl;

import com.example.marksmgmt.model.Student;
import com.example.marksmgmt.repository.StudentRepository;
import com.example.marksmgmt.service.StudentService;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Implementation of StudentService
 */
public class StudentServiceImpl implements StudentService {
    
    private StudentRepository studentRepository;
    
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Student findStudentById(Long id) {
        return studentRepository.findById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Student findStudentByRollNumber(String rollNumber) {
        return studentRepository.findByRollNumber(rollNumber);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }
    
    @Override
    @Transactional
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
} 