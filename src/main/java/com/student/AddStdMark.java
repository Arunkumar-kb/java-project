package com.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddMark")
public class AddStdMark extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String rollno,subcode,subname;
		int semester,t1,a1,q1,ext;
		rollno = request.getParameter("rollno");
		subcode = request.getParameter("subcode");
		subname = request.getParameter("subname");
		semester = Integer.parseInt(request.getParameter("sem"));
		t1 = Integer.parseInt(request.getParameter("t1"));
		a1 = Integer.parseInt(request.getParameter("a1"));
		q1 = Integer.parseInt(request.getParameter("q1"));
		ext = Integer.parseInt(request.getParameter("ext"));		 
//		out.println("\n" + rollno + "\n" + subcode + "\n" + subname + "\n" + semester + "\n" + t1 + "\n" + a1 + "\n" + q1 + "\n" + ext);
		if(DBUtil.addMark(semester,rollno, subname, subcode, t1, a1, q1,ext)) {
			response.sendRedirect("addMark.jsp");
		}
		else {
			response.sendRedirect("addMark.jsp?error=Invalid input or User not found");
		}
	}


}
