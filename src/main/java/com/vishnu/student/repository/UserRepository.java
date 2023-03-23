package com.vishnu.student.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishnu.student.pojos.Users;

public interface UserRepository extends JpaRepository<Users, Serializable>{

}
