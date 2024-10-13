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
import javax.servlet.http.HttpSession;

@WebServlet("/showResult")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<StudentMarks> MarkList = new ArrayList<>();
		PrintWriter out = response.getWriter();
		out.println("result dao");
		HttpSession session = request.getSession();

		String Rollno = (String) session.getAttribute("rollno");
		String semester = request.getParameter("sem");
		System.out.print(semester);
		if(semester==null) {
//			response.sendRedirect("result.jsp");
			semester = "0";
		}

		if(Rollno==null){
			response.sendRedirect("login.jsp");
		}
		else {
		try {
			Connection conn = DBUtil.getConnection();
			System.out.println("connection establized");
			String sql = "SELECT * FROM marks WHERE rollno=? and semester=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Rollno);
            stmt.setString(2, semester);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
				String rollno =rs.getString("rollno"); 
            	String sub_code = rs.getString("sub_code");
            	String sub_name = rs.getString("sub_name");
            	int t_1 = rs.getInt("t1"); 
				int a_1 = rs.getInt("a1");
				int q_1 = rs.getInt("q1");
				int ext = rs.getInt("ext"); 
				int total = rs.getInt("total");
				System.out.println(sub_code + " " + sub_name + " " + rollno + " " + t_1 + " " + a_1 + " " + q_1 + " " + ext + " " + total);
				
				 MarkList.add(new StudentMarks(rollno,sub_code,sub_name,t_1,q_1,a_1,total,ext));
			}
            
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error occured");
		}
		System.out.println("result...");
		System.out.println(MarkList.size());
		int size = MarkList.size();
		request.setAttribute("Listsize", size);
		request.setAttribute("Marklist", MarkList);
		request.setAttribute("sem",semester);
		RequestDispatcher rs = request.getRequestDispatcher("result.jsp");
		rs.forward(request, response);
		}
	}

}
