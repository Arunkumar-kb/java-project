package com.student;

public class MarkList {
	
	String rollno, subname, subcode;
	int t1,a1,q1,total,ext,sem;
	public MarkList(String rollno, String subname, String subcode, int t1, int a1, int q1, int total, int ext, int sem) {
		super();
		this.rollno = rollno;
		this.subname = subname;
		this.subcode = subcode;
		this.t1 = t1;
		this.a1 = a1;
		this.q1 = q1;
		this.total = total;
		this.ext = ext;
		this.sem = sem;
	}
	public int getSem() {
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public String getSubcode() {
		return subcode;
	}
	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}
	public int getT1() {
		return t1;
	}
	public void setT1(int t1) {
		this.t1 = t1;
	}
	public int getA1() {
		return a1;
	}
	public void setA1(int a1) {
		this.a1 = a1;
	}
	public int getQ1() {
		return q1;
	}
	public void setQ1(int q1) {
		this.q1 = q1;
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
