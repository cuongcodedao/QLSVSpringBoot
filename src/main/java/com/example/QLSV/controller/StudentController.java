package com.example.QLSV.controller;

import com.example.QLSV.entity.Student;
import com.example.QLSV.service.impl.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dang-van-cuong")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/view/{id}")
    public String getStudent(@PathVariable Long id, Model model) {
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "view_student";
    }

    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, Model model) {
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "update_student";
    }

    @GetMapping("/add")
    public String addStudent() {
        return "add_student";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/dang-van-cuong";
    }
    @GetMapping("")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }

    @PostMapping("/save")
    public String saveStudent(Student student) {
        studentService.saveStudent(student);
        return "redirect:/dang-van-cuong";
    }

    @DeleteMapping("/delete")
    public String deleteStudent(Student student) {
        studentService.deleteStudent(student.getId());
        return "redirect:/dang-van-cuong";
    }

    @PostMapping("/update")
    public String updateStudent(Student student) {
        studentService.updateStudent(student);
        return "redirect:/dang-van-cuong";
    }
}
