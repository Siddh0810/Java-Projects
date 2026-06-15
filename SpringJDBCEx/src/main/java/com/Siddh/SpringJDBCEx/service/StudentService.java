package com.Siddh.SpringJDBCEx.service;

import com.Siddh.SpringJDBCEx.model.Student;
import com.Siddh.SpringJDBCEx.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repository;

    public void addStudent(Student stud){
        System.out.println("save");
        repository.saveStudent(stud);
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }
}
