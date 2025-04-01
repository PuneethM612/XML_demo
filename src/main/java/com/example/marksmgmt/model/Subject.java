package com.example.marksmgmt.model;

import java.io.Serializable;

/**
 * Model class representing a Subject
 */
public class Subject implements Serializable {
    
    private Long id;
    private String name;
    private String code;
    private Integer credits;
    private String description;
    
    // Default constructor
    public Subject() {
    }
    
    // Constructor with fields
    public Subject(String name, String code, Integer credits, String description) {
        this.name = name;
        this.code = code;
        this.credits = credits;
        this.description = description;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public Integer getCredits() {
        return credits;
    }
    
    public void setCredits(Integer credits) {
        this.credits = credits;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Subject subject = (Subject) o;
        
        return id != null ? id.equals(subject.id) : subject.id == null;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    
    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", credits=" + credits +
                '}';
    }
} 