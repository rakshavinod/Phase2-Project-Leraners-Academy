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


@WebServlet("/delete-students")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteStudent() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		request.getRequestDispatcher("delete-students.html").include(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		
		int student_id = Integer.parseInt(request.getParameter("rollnum"));
		// build hibernate session factory
				try {
					// 1. load session factory
					SessionFactory factory = HibernateSessionUtil.buildSessionFactory();

					// 2. create a session
					Session session = factory.openSession();
					
					// 3. create transaction
					 Transaction tx = session.beginTransaction();
					 
					 //4. create product object
					 Student student = new Student(student_id);
					
					 student.setRollnum(student_id);
					 
					 //5. delete product
					 session.delete(student);
					 
					 //6. commit transaction.
					 tx.commit();

					if (session != null) {
						out.print("<h3 style='color:green'> Student is deleted sucessfully ! </h3>");
					}

					// close session
					session.close();
				} catch (Exception e) {
					out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
				}
			}

	}


