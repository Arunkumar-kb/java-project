package com.student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Login
 */
@WebServlet("/logIn")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String utype = request.getParameter("utype");
	    String uname = request.getParameter("uname");
        String password = request.getParameter("pwd");
        
        
        // Use utility class to validate user credentials
        if(DBUtil.validateUser(utype,uname, password)) {
        	HttpSession session = request.getSession();
            session.setAttribute("rollno", uname);
            if(uname.equals("admin")) {
            	response.sendRedirect("adminHeader.jsp");
            }
            else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/profileDao");
            dispatcher.forward(request, response);
//            response.sendRedirect("welcome.jsp");
            }
        } else {
            response.sendRedirect("login.jsp?error=Invalid email or password");
	}
}
}
