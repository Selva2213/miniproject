package com.kce.student.bean;

public class StudentExam extends Student{
private float attendence;
private String subject;

public StudentExam(int studId,float attendence,String subject) {
	super(studId);
	this.attendence=attendence;
	this.subject=subject;
}

public StudentExam(int studId, String studName, String studGrade, String studDep,float attendence,String subject) {
	super(studId, studName, studGrade, studDep);
	this.attendence=attendence;
	this.subject=subject;
}

public StudentExam() {
	super();
}

public float getAttendence() {
	return attendence;
}
public void setAttendence(float attendence) {
	this.attendence = attendence;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
@Override
public String toString() {
	return "StudentExam [id= "+getStudId()+", attendence=" + attendence + ", subject=" + subject + "]";
}

}
