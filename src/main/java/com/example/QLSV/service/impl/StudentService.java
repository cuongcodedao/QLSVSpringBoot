package com.example.QLSV.service.impl;

import com.example.QLSV.entity.Student;
import com.example.QLSV.repository.StudentRepository;
import com.example.QLSV.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;
    @Override
    public Student getStudent(Long id) throws RuntimeException{
        Optional<Student> student = studentRepository.findById(id);
        return student.orElseThrow(()-> new RuntimeException("Cannot find student with id " + id));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) throws RuntimeException {
        Student student = studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Cannot find student with id " + id));
        studentRepository.delete(student);
    }

    @Override
    public Student updateStudent(Student student) throws RuntimeException{
        Student existingStudent = studentRepository.findById(student.getId()).orElseThrow(()-> new RuntimeException("Cannot find student with id " + student.getId()));
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setGender(student.isGender());
        return studentRepository.save(existingStudent);
    }
}
