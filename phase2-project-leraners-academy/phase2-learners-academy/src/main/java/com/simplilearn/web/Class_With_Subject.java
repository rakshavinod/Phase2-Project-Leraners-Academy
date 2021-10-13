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

import com.simplilearn.model.ClassRoom;
import com.simplilearn.model.Learner_Subject;
import com.simplilearn.util.HibernateSessionUtil;

/**
 * Servlet implementation class ClassWithSubject
 */
@WebServlet("/add-product-with-details")
public class ClassWithSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ClassWithSubject() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//class details
		int classid = Integer.parseInt(request.getParameter("class_id"));
		String sec = request.getParameter("section");
		String className = request.getParameter("classname");
		
		//subject
		String sub_name = request.getParameter("subjectname");
		String sub_code = request.getParameter("subjectcoe");
		
		// build hibernate session factory
				try {
					// 1. load session factory
					SessionFactory factory = HibernateSessionUtil.buildSessionFactory();

					// 2. create a session
					Session session = factory.openSession();
					
					// 3. create transaction
					 Transaction tx = session.beginTransaction();
					 
					 //create onject
					 ClassRoom classDetails = new ClassRoom(classid, sec, className);
					 Learner_Subject subjectDetails = new Learner_Subject(sub_name, sub_code);
					 classDetails.setDetails(subjectDetails);
					 
					 //5. save product
					 session.save(classDetails);
					 
					 //6. commit transaction.
					 tx.commit();

					if (session != null) {
						out.print("<h3 style='color:green'>class is created with subject details sucessfully ! </h3>");
					}

					// close session
					session.close();
				} catch (Exception e) {
					out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
				}
				
					 
	}

}
