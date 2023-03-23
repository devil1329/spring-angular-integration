package com.vishnu.student.pojos;

import jakarta.persistence.*;

@Entity
@Table(name="Student")
public class Student {
	@Id
	@Column(name="STUDENT_ID")
	private int id;
	
	@Column(name="STUDENT_NAME")
	private String name;
	
	@Column(name="STANDARD")
	private int standard;
	
	@Column(name="STREAM")
	private String stream;
	
	Student(){}	
	
	public Student(int id, String name, int standard, String stream) {
		super();
		this.id = id;
		this.name = name;
		this.standard = standard;
		this.stream = stream;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", standard=" + standard + ", stream=" + stream + "]";
	}
	
}
