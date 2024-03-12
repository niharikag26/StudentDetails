package com.sd.in.controller;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sd.in.entity.Student;
import com.sd.in.exception.StudentNotFoundException;
import com.sd.in.repository.StudentRepository;


@RestController
@RequestMapping(value="/students")
public class StudentController {
	
	public StudentRepository repository;

	public StudentController(StudentRepository repository) {
		super();
		this.repository = repository;
	}
	
	@PostMapping(value="/saveStudent")
	public Student saveStudent(@RequestBody Student s) {
		
		return repository.save(s);
	}
	
	@GetMapping(value="/{id}")
	public Optional<Student> getStudent(@PathVariable Integer id) {
		Optional<Student> opt=repository.findById(id);
		if(opt.isEmpty()) {
			throw new StudentNotFoundException("Student with id: "+id+" is not available!");
		}
		return opt;
		
	}
	@DeleteMapping(value="/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		repository.deleteById(id);
		String s="customer with id: "+id+" is deleted!";
		return s;	
	}
	@PutMapping(value="/{id}")
	public Student updateStudent(@PathVariable Integer id, @RequestBody Student s) {
		 Optional<Student> s1=repository.findById(id);
		 Student updateStudent=s1.get();
		 updateStudent.setName(s.getName());
		 updateStudent.setAge(s.getAge());  
		 updateStudent.setEmail(s.getEmail());
	     repository.save(updateStudent);
		 return updateStudent;	
	}
	@PatchMapping("/{id}")
	public Student partialUpdate(@PathVariable Integer id, @RequestBody Student s) {
		Optional<Student> opt=repository.findById(id);
		Student updatedStudent=opt.get();
		updatedStudent.setEmail(s.getEmail());
		repository.save(updatedStudent);
		return updatedStudent;
		
	}
	
	
	

}
