package com.example.marksmgmt.model;

import java.io.Serializable;

/**
 * Model class representing a Student
 */
public class Student implements Serializable {
    
    private Long id;
    private String rollNumber;
    private String name;
    private String email;
    private String contactNumber;
    private String address;
    
    // Default constructor
    public Student() {
    }
    
    // Constructor with fields
    public Student(String rollNumber, String name, String email, String contactNumber, String address) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.address = address;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getRollNumber() {
        return rollNumber;
    }
    
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getContactNumber() {
        return contactNumber;
    }
    
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Student student = (Student) o;
        
        return id != null ? id.equals(student.id) : student.id == null;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", rollNumber='" + rollNumber + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
} 