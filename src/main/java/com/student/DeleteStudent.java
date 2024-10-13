package com.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteStd")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: deleteb ").append(request.getContextPath());
		
		String id = request.getParameter("id");
		String tname = request.getParameter("tname");
		System.out.println(id + tname);
		try {
			Connection conn = DBUtil.getConnection();
			if("student".equals(tname)) {
				String sql = "delete from " + tname + " where rollno = ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, id);
				int rs = stmt.executeUpdate();
				if(rs > 0) {
					System.out.println("row deleted successfully");
				}
				response.sendRedirect("viewStudent");
			}
			else if("marks".equals(tname)) {
				String sql = "delete from " + tname + " where sub_code = ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, id);
				int rs = stmt.executeUpdate();
				if(rs > 0) {
					System.out.println("row deleted successfully");
				}
				response.sendRedirect("ViewMarks");
			}
			else {
				System.out.println("Error occured");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
