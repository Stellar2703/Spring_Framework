package com.example.simpleWebApplication.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.example.simpleWebApplication.model.Student;

@Service
public class StudentService {

    ArrayList<Student> students = new ArrayList<>(
    Arrays.asList(
        new Student(1, "John Doe", 20, "john.doe@example.com"),
        new Student(2, "Jane Smith", 22, "jane.smith@example.com")
    )
);
    
    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id){
        for(Student student : students){
            if(student.id == id){
                return student;
            }
        }
        return null;
    }
    public void addStudent(Student student){
        students.add(student);
    }

    public void updateStudent(int id,Student entity){
        for(Student s : students){
            if(s.id==id){
                s.name = entity.name;
                s.age = entity.age;
            }
        }
    }
}
