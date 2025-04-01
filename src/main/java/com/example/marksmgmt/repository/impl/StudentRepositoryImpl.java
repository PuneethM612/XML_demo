package com.example.marksmgmt.repository.impl;

import com.example.marksmgmt.model.Student;
import com.example.marksmgmt.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Implementation of StudentRepository
 */
public class StudentRepositoryImpl implements StudentRepository {
    
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    @Transactional
    public Student save(Student student) {
        getCurrentSession().saveOrUpdate(student);
        return student;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return getCurrentSession().get(Student.class, id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Student findByRollNumber(String rollNumber) {
        Query<Student> query = getCurrentSession().createQuery(
                "FROM Student WHERE rollNumber = :rollNumber", Student.class);
        query.setParameter("rollNumber", rollNumber);
        return query.uniqueResult();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return getCurrentSession().createQuery("FROM Student", Student.class).list();
    }
    
    @Override
    @Transactional
    public void deleteById(Long id) {
        Student student = findById(id);
        if (student != null) {
            getCurrentSession().delete(student);
        }
    }
} 