package com.example.demo.exceptions;



public class StudentNotFountException extends RuntimeException {

	@Override
	public String toString() {
		return "Entered id not matched with records";
	}
}
