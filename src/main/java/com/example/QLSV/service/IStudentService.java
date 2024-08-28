package com.example.QLSV.service;

import com.example.QLSV.entity.Student;

import java.util.List;

public interface IStudentService {
    Student getStudent(Long id) throws Exception;
    List<Student> getAllStudents();
    Student saveStudent(Student student) throws Exception;
    void deleteStudent(Long id) throws Exception;
    Student updateStudent(Student student) throws Exception;
}
