package com.example.simpleWebApplication.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.simpleWebApplication.model.Student;
import com.example.simpleWebApplication.service.StudentService;



@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/student")
    public String addStudent(@RequestBody Student entity) {
        studentService.addStudent(entity);
        return "Added Suucessfully";
    }

    @PutMapping("student/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student entity) {
        studentService.updateStudent(id,entity);
        return "Updated the student detials for the id"+id+" Successfully";
    }

    @DeleteMapping("student/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return "Delted the id successfully";
    }
    
}
