package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public class StudentRepository {

	static List<Student> studentList = new ArrayList<Student>();
	
	Student student = new Student();
	
	static {
		studentList.add(new Student(10, "abc", "abc-address", 909090090));
		studentList.add(new Student(20, "pqr", "pqr-address", 845231254));
		studentList.add(new Student(30, "lmn", "lmn-address", 660170800));
		studentList.add(new Student(40, "xyz", "xyz-address", 405468786));
	}
	
	public List<Student> getAll(){
		return studentList;
	}
	
	
	public Student getById(int id) {
		for (Student student : studentList) {
			int value = student.getId();
			if(value == id) {
				return student;
			}
		}
		return null;
	}
	
	public void addData(int id, String name, String address, int mobno) {
		studentList.add(new Student(id, name, address, mobno));
	}
	
	
}
