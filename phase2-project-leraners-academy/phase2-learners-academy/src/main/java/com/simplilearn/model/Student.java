package com.simplilearn.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Student_table")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "class_id")
	private int class_id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="Rollnum")
	private int Rollnum;
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Teacher teacher;
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student(String firstName, String lastname, int rollnum) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
		Rollnum = rollnum;
	}

	public Student(int rollnum) {
		super();
		Rollnum = rollnum;
	}

	public int getStudent_id() {
		return class_id;
	}

	public void setStudent_id(int student_id) {
		this.class_id = student_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getRollnum() {
		return Rollnum;
	}

	public void setRollnum(int rollnum) {
		Rollnum = rollnum;
	}
	
	

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	
	@Override
	public String toString() {
		return "Student [student_id=" + class_id + ", firstName=" + firstName + ", lastname=" + lastname
				+ ", Rollnum=" + Rollnum + "]";
	}
}
