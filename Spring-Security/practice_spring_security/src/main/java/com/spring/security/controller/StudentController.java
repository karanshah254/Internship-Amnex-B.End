package com.spring.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	public List<Student> students = new ArrayList<>(
			List.of(
                    new Student(1, "Navin", 60),
                    new Student(2, "Kiran", 65)
                    ));
	
	@GetMapping("/students")
	public List<Student> getStudents() {
        return students;
    }
	
	@GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
		// it is to generate csrf token for POST, PUT, DELETE http calls
        return (CsrfToken) request.getAttribute("_csrf");
    }


    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) { // to add record we need csrf token in header 
        students.add(student);
        return student;
    }
}
