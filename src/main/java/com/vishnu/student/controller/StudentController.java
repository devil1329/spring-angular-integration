package com.vishnu.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishnu.student.pojos.Student;
import com.vishnu.student.repository.StudentRepository;

@RestController
@RequestMapping(value = "/api/students")
public class StudentController {

	@Autowired
	StudentRepository studentRepo;
	
	@RequestMapping("/get-all-student-details")
	public List<Student> getAllStudentDetails(){
		System.out.println("Request Processes!!!");
		List<Student> list = studentRepo.findAll();
		return list;
	}
	
	@GetMapping("/studentRecordsInSortedOrderByName")
	public List<Student> studentRecordsInSortedOrder(){
		List<Student> list = studentRepo.getRecordsInSortedOrderByStudentName();
		return list;
	}
	
	@PostMapping("/add-student-record")
	public String addStudent( @RequestBody Student stuObj) 
	{
		System.out.println("Received data to insert is : "+stuObj);
		Student obj = studentRepo.save(stuObj);
		return "Record inserted successfully in the database..\n" + obj;
	}
	
	@PutMapping("/update-student-record")
	public String updateStudent(@RequestBody Student stuObj) {
		System.out.println("Received data to update is : "+stuObj);
		Optional<Student> opObj = studentRepo.findById(stuObj.getId());
		
		if(opObj.isPresent()) {
			Student obj = opObj.get();
			obj.setName(stuObj.getName());
			obj.setStandard(stuObj.getStandard());
			obj.setStream(stuObj.getStream());
			studentRepo.save(obj);
			return "Record updated successfully...\nUpdated Record : "+obj;
		}

		return "Record not found...";
	}
	
	@GetMapping("/get-student/{id}")
	public Student getStudent(@PathVariable int id) {
		Student stuObj;
		Optional<Student> opObj = studentRepo.findById(id);
		stuObj = opObj.get();
		return stuObj;
	}
	
	@DeleteMapping("/delete-student-record/{id}")
	public String deleteStudentRecord(@PathVariable int id) {
		System.out.println("Received Insurance id to delete is : "+id);
		Optional<Student> opObj = studentRepo.findById(id);
		
		if(opObj.isPresent()) {
			studentRepo.deleteById(id);
			return "Student's record having id "+id+" is successfully deleted!!!";
		}
		
		return "No record present with this id : "+id;
	}
	
}
