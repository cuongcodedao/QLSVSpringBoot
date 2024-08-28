package com.example.QLSV.service;

import com.example.QLSV.entity.Student;

import java.util.List;

public interface IStudentService {
    Student getStudent(Long id);
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    Student updateStudent(Student student);
}
