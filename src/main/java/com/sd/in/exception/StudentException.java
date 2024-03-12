package com.sd.in.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentException {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> HandleStudentNotFoundException(StudentNotFoundException s){
		return new ResponseEntity<String>(s.getMessage(),HttpStatus.NOT_FOUND);
	}

}
