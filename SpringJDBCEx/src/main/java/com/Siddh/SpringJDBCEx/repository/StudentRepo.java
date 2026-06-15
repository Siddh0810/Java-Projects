package com.Siddh.SpringJDBCEx.repository;

import com.Siddh.SpringJDBCEx.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public void saveStudent(Student student){
        String sql = "insert into student (rollNo,name,marks) values (?,?,?)";
        int rows = jdbc.update(sql, student.getRollNo(), student.getName(), student.getMarks());
        System.out.println(rows + " affected");
    }

    public List<Student> findAll(){

        String sql = "select * from student";
        return jdbc.query(sql, (rs, rowNum)-> {
                Student s = new Student();
                s.setRollNo(rs.getInt("rollNo"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;
            });
        };
    }
