package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class profileDao
 */
@WebServlet("/profileDao")
public class profileDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		out.println("profile dao");
		String rollno = (String) session.getAttribute("rollno");
		out.println(rollno);
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "select sname,email,mobile,course,gender from student where rollno=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, rollno);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	String sname = rs.getString("sname");
            	String email = rs.getString("email");
            	String mobile = rs.getString("mobile");
            	String course = rs.getString("course");
            	String gender = rs.getString("gender");
            	session.setAttribute("sname", sname);
            	session.setAttribute("email", email);
            	session.setAttribute("mobile", mobile);
            	session.setAttribute("course", course);
            	session.setAttribute("gender", gender);
            	out.println(sname + rollno + email + mobile + course + gender);
            	response.sendRedirect("header.jsp");
            }
      
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
