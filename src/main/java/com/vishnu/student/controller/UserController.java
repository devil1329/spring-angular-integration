package com.vishnu.student.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishnu.student.pojos.Users;
import com.vishnu.student.repository.UserRepository;

@RestController
@RequestMapping(value = "/api/students")
public class UserController {
	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/login")
	public String login(@RequestBody Users userObj) {
		Optional<Users> opObj = userRepo.findById(userObj.getUsername());
		if(opObj.isPresent()) {
			Users obj = opObj.get();
			String str = obj.getPassword()+" "+userObj.getPassword();
			if(obj.getPassword().equals(userObj.getPassword()) ) {				
				return "login successfull!!";	
			}
			return "Wrong Password!!!";
		}
		return "User not registered!!";
	}
	
	@PostMapping("/register")
	public String register(@RequestBody Users userObj)
	{
		Optional<Users> opObj = userRepo.findById(userObj.getUsername());
		if(opObj.isPresent()) {
			return "User already Registered!!";
		}
		userRepo.save(userObj);
		return "registered successfully!!!";
	}
}
