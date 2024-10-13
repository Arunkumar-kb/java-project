package com.student;

public class StudentView {
	String sname,rollno,email,mobile,course,gender;

	public StudentView(String sname, String rollno, String email, String mobile, String course, String gender) {
		super();
		this.sname = sname;
		this.rollno = rollno;
		this.email = email;
		this.mobile = mobile;
		this.course = course;
		this.gender = gender;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
