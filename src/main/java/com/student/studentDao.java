package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewStudent")
public class studentDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<StudentView> StudentList = new ArrayList<>();
		String sname,rollno,email,mobile,course,gender;
		PrintWriter out = response.getWriter();
		out.println("Student view dao");
		try {
			Connection conn = DBUtil.getConnection();
			System.out.println("connection establized");
			String sql = "SELECT * FROM student";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
	        while(rs.next()) {
	        	sname = rs.getString("sname");
	        	rollno = rs.getString("rollno");
	        	email = rs.getString("email");
	        	mobile = rs.getString("mobile");
	        	course = rs.getString("course");
	        	gender = rs.getString("gender");
	        	System.out.println(sname + rollno + email + mobile + course + gender);
	        	StudentList.add(new StudentView(sname,rollno,email,mobile,course,gender));
	        }
		} catch (Exception e) {
			System.out.println("error ocuured in student Dao");
		}
		request.setAttribute("studentList", StudentList);
		RequestDispatcher rs = request.getRequestDispatcher("viewStd.jsp");
		rs.forward(request,response);
	}
	}


