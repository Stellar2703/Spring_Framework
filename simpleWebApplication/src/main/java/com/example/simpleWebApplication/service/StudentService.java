package com.example.simpleWebApplication.service;

import java.util.ArrayList;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simpleWebApplication.model.Student;
import com.example.simpleWebApplication.repository.StudentRepo;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;
//    ArrayList<Student> students = new ArrayList<>(
//    Arrays.asList(
//        new Student(1, "John Doe", 20, "john.doe@example.com"),
//        new Student(2, "Jane Smith", 22, "jane.smith@example.com")
//    )
//);
    
//    public List<Student> getAllStudents() {
//        return repo.findAll();
//    }

    public List<Student> getAllStudents(){
        return repo.findAll();
    }

    public Student getStudentById(int id){
        return repo.findById(id).orElse(new Student());
    }
    public void addStudent(Student student){
        repo.save(student);
    }

    public void updateStudent(int id,Student entity){
        repo.save(entity);
    }
    public void deleteStudent(int id){
        repo.deleteById(id);
    }
}
