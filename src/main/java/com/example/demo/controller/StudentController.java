package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.StudentNotFountException;
import com.example.demo.model.ErrorDetail;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentController {

	@Autowired
	StudentService service;
	
	@GetMapping("/")
	public List<Student> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/id/{id}")
	public Student getById(@PathVariable ("id") int id) {
		Student student = service.getById(id);
		if(student == null) {
			throw new StudentNotFountException();
		}
		
		return student;
	}
	
	@PostMapping("/add")
	public void addData(@RequestBody Student student) {
		service.addData(student);
	}
	
	@ExceptionHandler(StudentNotFountException.class)
	public ResponseEntity<ErrorDetail> handleException(Exception exception){
		ErrorDetail error = new ErrorDetail("Sorry record not found", HttpStatus.NOT_FOUND);
		ResponseEntity<ErrorDetail> res = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		return res;
		
	}
}
