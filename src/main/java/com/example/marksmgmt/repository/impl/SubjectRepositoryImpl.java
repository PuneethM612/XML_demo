package com.example.marksmgmt.repository.impl;

import com.example.marksmgmt.model.Subject;
import com.example.marksmgmt.repository.SubjectRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Implementation of SubjectRepository
 */
public class SubjectRepositoryImpl implements SubjectRepository {
    
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    @Transactional
    public Subject save(Subject subject) {
        getCurrentSession().saveOrUpdate(subject);
        return subject;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Subject findById(Long id) {
        return getCurrentSession().get(Subject.class, id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Subject findByCode(String code) {
        Query<Subject> query = getCurrentSession().createQuery(
                "FROM Subject WHERE code = :code", Subject.class);
        query.setParameter("code", code);
        return query.uniqueResult();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Subject> findAll() {
        return getCurrentSession().createQuery("FROM Subject", Subject.class).list();
    }
    
    @Override
    @Transactional
    public void deleteById(Long id) {
        Subject subject = findById(id);
        if (subject != null) {
            getCurrentSession().delete(subject);
        }
    }
} 