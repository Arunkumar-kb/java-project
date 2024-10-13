package com.student;

public class StudentMarks {
	public String rollno,sub_code,sub_name;
	public int t_1,q_1,a_1,total,ext;
	
	public StudentMarks(String rollno, String sub_code, String sub_name, int t_1, int q_1, int a_1, int total,
			int ext) {
		super();
		this.rollno = rollno;
		this.sub_code = sub_code;
		this.sub_name = sub_name;
		this.t_1 = t_1;
		this.q_1 = q_1;
		this.a_1 = a_1;
		this.total = total;
		this.ext = ext;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getSub_code() {
		return sub_code;
	}

	public void setSub_code(String sub_code) {
		this.sub_code = sub_code;
	}

	public String getSub_name() {
		return sub_name;
	}

	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}

	public int getT_1() {
		return t_1;
	}

	public void setT_1(int t_1) {
		this.t_1 = t_1;
	}

	public int getQ_1() {
		return q_1;
	}

	public void setQ_1(int q_1) {
		this.q_1 = q_1;
	}

	public int getA_1() {
		return a_1;
	}

	public void setA_1(int a_1) {
		this.a_1 = a_1;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getExt() {
		return ext;
	}

	public void setExt(int ext) {
		this.ext = ext;
	}
	
}
