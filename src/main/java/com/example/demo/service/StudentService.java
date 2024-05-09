package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repo;
	

	public List<Student> getAll() {
		List<Student> studentlist = repo.getAll();
		return studentlist;
	}
	
	public Student getById(int id) {
		return repo.getById(id);
	}
	
	public void addData(Student std) {
		repo.addData(std.getId(), std.getName(), std.getAddress(), std.getMobno());
	}
}
