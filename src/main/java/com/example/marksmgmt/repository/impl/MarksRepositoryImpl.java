package com.example.marksmgmt.repository.impl;

import com.example.marksmgmt.model.ExamType;
import com.example.marksmgmt.model.Marks;
import com.example.marksmgmt.model.Student;
import com.example.marksmgmt.repository.MarksRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Implementation of MarksRepository
 */
public class MarksRepositoryImpl implements MarksRepository {
    
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    @Transactional
    public Marks save(Marks marks) {
        getCurrentSession().saveOrUpdate(marks);
        return marks;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Marks findById(Long id) {
        return getCurrentSession().get(Marks.class, id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Marks> findAll() {
        return getCurrentSession().createQuery("FROM Marks", Marks.class).list();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Marks> findByStudent(Student student) {
        Query<Marks> query = getCurrentSession().createQuery(
                "FROM Marks WHERE student = :student", Marks.class);
        query.setParameter("student", student);
        return query.list();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Marks> findByStudentAndExamType(Student student, ExamType examType) {
        Query<Marks> query = getCurrentSession().createQuery(
                "FROM Marks WHERE student = :student AND examType = :examType", Marks.class);
        query.setParameter("student", student);
        query.setParameter("examType", examType);
        return query.list();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Marks> findByExamType(ExamType examType) {
        Query<Marks> query = getCurrentSession().createQuery(
                "FROM Marks WHERE examType = :examType", Marks.class);
        query.setParameter("examType", examType);
        return query.list();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Object[]> findTopStudentsByExamType(ExamType examType, int limit) {
        String hql = "SELECT m.student, SUM(m.marks) as totalMarks " +
                     "FROM Marks m " +
                     "WHERE m.examType = :examType " +
                     "GROUP BY m.student " +
                     "ORDER BY totalMarks DESC";
        
        Query<Object[]> query = getCurrentSession().createQuery(hql, Object[].class);
        query.setParameter("examType", examType);
        query.setMaxResults(limit);
        
        return query.list();
    }
    
    @Override
    @Transactional
    public void deleteById(Long id) {
        Marks marks = findById(id);
        if (marks != null) {
            getCurrentSession().delete(marks);
        }
    }
} 