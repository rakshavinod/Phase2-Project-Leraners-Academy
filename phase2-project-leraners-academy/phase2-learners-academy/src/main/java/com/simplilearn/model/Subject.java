package com.simplilearn.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Subject_lists")

public class Subject {
	
	@Id
	@Column(name="class_id")
	int class_id;
	
	@Column(name="subject_name")
	String subject_name;
	
	@Column(name="subject_code")
	String subjectcode;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="Student_table", joinColumns=@JoinColumn(name="class_id"),
	inverseJoinColumns=@JoinColumn(name="Rollnum"))
	private Set<Student> student;
	

	public Subject(String subject_name, String subjectcode) {
		super();
		this.subject_name = subject_name;
		this.subjectcode = subjectcode;
	}

	public Subject(int class_id, String subject_name, String subjectcode) {
		super();
		this.class_id = class_id;
		this.subject_name = subject_name;
		this.subjectcode = subjectcode;
	}
	

	public Subject() {
		super();
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public String getSubjectcode() {
		return subjectcode;
	}

	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}
}
