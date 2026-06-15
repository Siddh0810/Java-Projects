package com.Siddh.SpringJDBCEx;

import com.Siddh.SpringJDBCEx.model.Student;
import com.Siddh.SpringJDBCEx.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);

		Student s = context.getBean(Student.class);
		s.setMarks(100);
		s.setName("ABC");
		s.setRollNo(1);

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s);

		List<Student> studentList = service.getStudents();
		System.out.println(studentList);

	}
}
