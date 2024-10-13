package com.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String sname = request.getParameter("sname");
		String rollno = request.getParameter("rollno");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String dept = request.getParameter("dept");
		String gender = request.getParameter("gender");
		String pwd = request.getParameter("pwd");
		
		if(DBUtil.registerUser(sname, rollno, email, mobile, dept, gender, pwd)) {
			response.sendRedirect("register.jsp");
		}
		else {
			response.sendRedirect("register.jsp?error=Invalid input or already registered");
		}
	}

}
