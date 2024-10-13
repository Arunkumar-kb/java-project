package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class DBUtil
 */
@WebServlet("/DBUtil")
public class DBUtil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 public static Connection getConnection() throws Exception {
	        String url = "jdbc:mysql://localhost:3306/std_db";
	        String username = "root";
	        String passwrd = "";
	        Class.forName("com.mysql.jdbc.Driver");
	        return DriverManager.getConnection(url, username, passwrd);
	  }
	    public static boolean registerUser(String SNAME, String ROLLNO, String EMAIL, String MOBILE, String COURSE, String GENDER, String PASSWORD) {
	        try (Connection conn = getConnection()) {
	        	if(SNAME.equals("") || EMAIL.equals("") || PASSWORD.equals("")) {
	        		return false;
	        	}
	        	else {
	            String sql = "INSERT INTO student (SNAME, ROLLNO, EMAIL, MOBILE, COURSE, GENDER, PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, SNAME);
	            stmt.setString(2, ROLLNO);
	            stmt.setString(3, EMAIL);
	            stmt.setString(4, MOBILE);
	            stmt.setString(5, COURSE);
	            stmt.setString(6, GENDER);
	            stmt.setString(7, PASSWORD);
	            stmt.executeUpdate();
	            return true;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	    public static boolean validateUser(String utype,String rollno, String password) {
	    	if(utype.equals("admin")&& password.equals("admin")) {
	    		return true;
	    	}
	    	else if(utype.equals("student")) {
	        try (Connection conn = getConnection()) {
	            String sql = "SELECT * FROM student WHERE ROLLNO = ? AND PASSWORD = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, rollno);
	            stmt.setString(2, password);
	            ResultSet rs = stmt.executeQuery();
	            return rs.next();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    	}
	    	else {
	    		return false;
	    	}
	    }
	    
	    public static boolean addMark(int semester, String rollno, String subname, String subcode, int t1, int a1, int q1, int ext) {
	    	if(rollno == null){
	    		return false;
	    	}
	    	try(Connection conn = getConnection()){
	    		String sql = "insert into marks (rollno,sub_code,sub_name,t1,a1,q1,ext,semester) values (?,?,?,?,?,?,?,?)";
	    		PreparedStatement stmt = conn.prepareStatement(sql);
	    		stmt.setString(1,rollno);
	    		stmt.setString(2,subcode);
	    		stmt.setString(3,subname);
	    		stmt.setInt(4,t1);
	    		stmt.setInt(5,a1);
	    		stmt.setInt(6,q1);;
	    		stmt.setInt(7, ext);
	    		stmt.setInt(8, semester);
	    		System.out.println( "addmark"+stmt.executeUpdate());
	            return true;
	    	}
	    	catch(Exception e) {
	    		return false;
	    	}
	    }
}

