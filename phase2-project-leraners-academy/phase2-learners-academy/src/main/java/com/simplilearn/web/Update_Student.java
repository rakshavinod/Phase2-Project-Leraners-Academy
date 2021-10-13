package com.simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.model.Student;
import com.simplilearn.util.HibernateSessionUtil;



@WebServlet("/update-students")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateStudent() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		request.getRequestDispatcher("update-students.html").include(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		//student details
				String firstName = request.getParameter("firstName");
				String lastname = request.getParameter("lastname");
				int rollnum = Integer.parseInt(request.getParameter("rollnum"));
				try {
					// 1. load session factory
					SessionFactory factory = HibernateSessionUtil.buildSessionFactory();

					// 2. create a session
					Session session = factory.openSession();
					
					// 3. create transaction
					 Transaction tx = session.beginTransaction();
					 
					 //4. create product object
					Student student = new Student(firstName, lastname, rollnum);
					 
					 //5. update product
					 session.update(student);
					 
					 //6. commit transaction.
					 tx.commit();

					if (session != null) {
						out.print("<h3 style='color:green'> Student is update sucessfully ! </h3>");
					}

					// close session
					session.close();
				} catch (Exception e) {
					out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
				}
	}

}
