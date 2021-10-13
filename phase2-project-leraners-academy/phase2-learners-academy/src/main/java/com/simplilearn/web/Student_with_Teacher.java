package com.simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.model.Student;
import com.simplilearn.model.Teacher;
import com.simplilearn.util.HibernateSessionUtil;

/**
 * Servlet implementation class StudentsWithTeacher
 */
@WebServlet("/add-students-with-teacher")
public class StudentsWithTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public StudentsWithTeacher() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		request.getRequestDispatcher("add-students-with-teacher.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		
		//get student details
		//student details
		String firstName1 = request.getParameter("firstName1");
		String lastname1 = request.getParameter("lastname1");
		int rollnum1 = Integer.parseInt(request.getParameter("rollnum1"));
		
		//student details2
		String firstName2 = request.getParameter("firstName2");
		String lastname2 = request.getParameter("lastname2");
		int rollnum2 = Integer.parseInt(request.getParameter("rollnum2"));
		
		//teacher details
		String teachername = request.getParameter("TeacherName");
		int teacherage = Integer.parseInt(request.getParameter("age"));
		int exp = Integer.parseInt(request.getParameter("experience"));
		String teacherQualification = request.getParameter("qualification");
		
		// build hibernate session factory
				try {
					// 1. load session factory
					SessionFactory factory = HibernateSessionUtil.buildSessionFactory();

					// 2. create a session
					Session session = factory.openSession();

					// 3. create transaction
					Transaction tx = session.beginTransaction();
					
					//create obj
					//Set<ClassRoom> classroom = new HashSet<>();
					Set<Student> students = new HashSet<>();
					Student student1 = new Student(firstName1, lastname1, rollnum1);
					Student student2 = new Student(firstName2, lastname2, rollnum2);
					
					//teacher deatils
					Teacher teacher = new Teacher(teachername,teacherage, exp, teacherQualification);
					session.persist(teacher);
					// 6. set product to order
					student1.setTeacher(teacher);
					student2.setTeacher(teacher);

					// 5. save product
					session.save(student1);
					session.save(student2);
		
					// 6. commit transaction.
					tx.commit();

					if (session != null) {
						out.print("<h3 style='color:green'> Students assigned to teacher sucessfully ! </h3>");
					}

					// close session
					session.close();
				} catch (Exception e) {
					out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>" + e);
				}
	}

}
