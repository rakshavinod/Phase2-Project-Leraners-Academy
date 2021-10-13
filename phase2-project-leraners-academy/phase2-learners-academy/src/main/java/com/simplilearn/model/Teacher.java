package com.simplilearn.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Teacher Details")

public class Teacher {
	
	@Id
	@GeneratedValue
	@Column(name = "class_id")
	private int class_id;
	
	@Column(name="Teacher_Name")
	private String TeacherName;
	
	@Column(name="Teacher_age")
	private int age;
	
	@Column(name="Total_Experience")
	private int experience;
	
	@Column(name="Qualification")
	private String qualification;

	public Teacher(String teacherName, int age, int experience, String qualification) {
		super();
		TeacherName = teacherName;
		this.age = age;
		this.experience = experience;
		this.qualification = qualification;
	}

	public Teacher() {
		super();
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getTeacherName() {
		return TeacherName;
	}

	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "Teacher [class_id=" + class_id + ", TeacherName=" + TeacherName + ", age=" + age + ", experience="
				+ experience + ", qualification=" + qualification + "]";
	}
}
