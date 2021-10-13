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
@Table(name="classroom")
public class ClassRoom {
	
	@Id
	@GeneratedValue
	@Column(name = "class_id")
	private int class_id;
	 
	@Column(name="class_section")
	private String section;
	@Column(name = "class_name")
	private String classname;
	 
    @OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="class_id")
	 
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<Student> students;
	  
	private Subject details;
	 
	public Subject getDetails() {
		return details;
	}

	public void setDetails(Subject details) {
		this.details = details;
	}

	public Classroom(int class_id, String section, String classname) {
		super();
		this.class_id = class_id;
		this.section = section;
		this.classname = classname;
	}

	public Classroom(String section, String classname) {
		super();
		this.section = section;
		this.classname = classname;
	}

	public Classroom() {
		super();
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Classroom [class_id=" + class_id + ", section=" + section + ", classname=" + classname + ", students="
				+ students + ", details=" + details + "]";
	}
}
