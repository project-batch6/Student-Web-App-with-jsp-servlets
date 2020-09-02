package com.dxc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.beans.Exam;
import com.dxc.dao.ExamJdbcDAO;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateExam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session!=null && session.getAttribute("un")!=null) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			try {
			String ids = request.getParameter("id");
			int id = Integer.parseInt(ids);
			String name = request.getParameter("exam_name");
											   
			System.out.println(name);
				ExamJdbcDAO exm = new ExamJdbcDAO();
				Exam exam = new Exam();
				
				exam.setId(id);
				exam.setExam_name(name);
				
				
				boolean o = exm.edit(exam);
				
				if(o) {
					RequestDispatcher rd = request.getRequestDispatcher("DisplayExams.jsp");
					rd.forward(request, response);
				}
		
				else {
					out.println("details failed to update");
					out.println(id);
				}
		
		//	RequestDispatcher rd = request.getRequestDispatcher("DisplayStudents.jsp");
		//	rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}
		else {
			response.sendRedirect("Login.jsp");
		}

  }
}
