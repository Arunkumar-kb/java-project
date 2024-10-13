package com.student;

import java.io.IOException;
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


@WebServlet("/ViewMarks")
public class ViewMarksDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<MarkList> markList = new ArrayList<>();
		String rollno, subname, subcode;
		int t1,a1,q1,total,ext,sem;
		Connection conn;
		try {
			conn = DBUtil.getConnection();
			System.out.println("connection establized");
			String sql = "SELECT * FROM marks";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
	        while(rs.next()) {
	        	rollno = rs.getString("rollno");
	        	subname = rs.getString("sub_name");
	        	subcode = rs.getString("sub_code");
	        	t1 = rs.getInt("t1");
	        	a1 = rs.getInt("a1");
	        	q1 = rs.getInt("q1");
	        	total = rs.getInt("total");
	        	ext = rs.getInt("ext");
	        	sem = rs.getInt("semester");
	        	System.out.println(rollno + subname + subcode + total + ext);
	        	markList.add(new MarkList(rollno,subname,subcode,t1,a1,q1,total,ext,sem));
	        	
	        }
		} catch (Exception e) {
			System.out.println("Error occured" + e.getMessage());
		}
		request.setAttribute("markList", markList);
		RequestDispatcher rs = request.getRequestDispatcher("viewMarks.jsp");
		rs.forward(request,response);
		
	}



}
