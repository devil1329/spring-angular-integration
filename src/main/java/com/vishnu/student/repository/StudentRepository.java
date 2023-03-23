package com.vishnu.student.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vishnu.student.pojos.Student;

public interface StudentRepository extends JpaRepository<Student, Serializable>{

	@Query(value="select * from STUDENT order by STUDENT_NAME", nativeQuery=true)
	public List<Student> getRecordsInSortedOrderByStudentName();
}
