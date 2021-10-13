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

import com.simplilearn.model.ClassRoom;
import com.simplilearn.model.Student;
import com.simplilearn.util.HibernateSessionUtil;
/**
 * Servlet implementation class ClassWithStudent
 */
@WebServlet("/add-class-with-student")
public class ClassWithStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ClassWithStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		request.getRequestDispatcher("add-class-with-student.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);

		//get class details
		//class details
				int classid = Integer.parseInt(request.getParameter("class_id"));
				String sec = request.getParameter("section");
				String className = request.getParameter("classname");
				
				//student details
				String firstName1 = request.getParameter("firstName1");
				String lastname1 = request.getParameter("lastname1");
				int rollnum1 = Integer.parseInt(request.getParameter("rollnum1"));
				
				//student details2
				String firstName2 = request.getParameter("firstName2");
				String lastname2 = request.getParameter("lastname2");
				int rollnum2 = Integer.parseInt(request.getParameter("rollnum2"));
				
				// build hibernate session factory
				try {
					// 1. load session factory
					SessionFactory factory = HibernateSessionUtil.buildSessionFactory();

					// 2. create a session
					Session session = factory.openSession();

					// 3. create transaction
					Transaction tx = session.beginTransaction();
					
					//create object
					
					ClassRoom classroom = new ClassRoom(classid ,sec, className);
					//Student student = new Student(className ,sec, classid);
					
					//Set<ClassRoom> classroom = new HashSet<>();
					Set<Student> students = new HashSet<>();
					Student student1 = new Student(firstName1, lastname1, rollnum1);
					Student student2 = new Student(firstName2, lastname2, rollnum2);
					
					students.add(student1);
					students.add(student2);
					// add products list to order
					classroom.setStudents(students);
					// 5. save product
					session.save(classroom);

					// 6. commit transaction.
					tx.commit();

					if (session != null) {
						out.print("<h3 style='color:green'> Students are added to the classes  sucessfully ! </h3>");
					}

					// close session
					session.close();
				} catch (Exception e) {
					out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>"+e);
				}

					
					

				
				
	}

}
