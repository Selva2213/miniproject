package com.kce.student.bean;

public class Student {
	private String studName;
	private int studId;
	private String studGrade;
	private String studDep;
	
	public Student(int studId) {
		super();
		this.studId=studId;
	}
	public Student() {
		super();
	}
	public Student(int studId,String studName,String studGrade,String studDep) {
		this.studName=studName;
		this.studId=studId;
		this.studGrade=studGrade;
		this.studDep=studDep;
	}
	@Override
	public String toString() {
		return "Student [studName=" + studName + ", studId=" + studId + ", studGrade=" + studGrade + ", studDep="
				+ studDep + "]";
	}
	public  String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudGrade() {
		return studGrade;
	}
	public void setStudGrade(String studGrade) {
		this.studGrade = studGrade;
	}
	public String getStudDep() {
		return studDep;
	}
	public void setStudDep(String studDep) {
		this.studDep = studDep;
	}
	
}
