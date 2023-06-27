package com.kce.student.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Formatter;
import java.util.List;
//import java.io.*;
import java.util.Scanner;
import java.util.stream.Collectors;
import com.kce.student.bean.Student;
import com.kce.student.bean.StudentExam;
import com.kce.student.dao.DBOperation;
import com.kce.student.dao.DBOperation2;

public class Main {
public static void main(String[] args) {
	try {
		Scanner sc=new Scanner(System.in);
		Student sgh=new Student();
		StudentExam sed=new StudentExam();
		System.out.println("Please enter the choice to perform operation:\n1:Insert:\n2:Update:\n3:Delete:\n4:Display a table:\n5:Display a single record");
		int num=sc.nextInt();
		int count=0;
		if(num==1)
		{
			System.out.println("Please enter the student details to be inserted:");
			System.out.println("Student id:");
			int id=sc.nextInt();sc.nextLine();
			System.out.println("Student name:");
			String name=sc.nextLine();
			System.out.println("Student Grade:");
			String grade=sc.nextLine();
			System.out.println("Student Department:");
			String dep=sc.nextLine();
			System.out.println("Subject:");
			String sub=sc.nextLine();
			System.out.println("Attendence Percentage:");
			float ft=sc.nextFloat();
			sed.setStudId(id);
			sgh.setStudId(id);
			sgh.setStudName(name);
			sgh.setStudGrade(grade);
			sgh.setStudDep(dep);
			sed.setSubject(sub);
			sed.setAttendence(ft);
			if(DBOperation.insertion(sgh) )
				System.out.println("student records inserted");
			else
				System.out.println("wrong input");
			if(DBOperation2.insertion(sed))
				System.out.println("student exam records inserted");
			else 
				System.out.println("wrong input");
			count++;
		}
		else if(num==2)
		{
			System.out.println("Please enter the student id and user choice which feild to be updated:\n1:Name:\n2:Grade:\n3:Department:\n4:Attendence Percentage:\n5:Subject");
			int gud=sc.nextInt();
			sed.setStudId(gud);
			sgh.setStudId(gud);
			int cho=sc.nextInt();
			if(cho==1) {
				System.out.println("Please enter the student name that has to updated");
				if(DBOperation.updateName(sgh)) {
					System.out.println("Updated!!");
				}
			}
			else if(cho==2) {
				System.out.println("Please enter the student grade that has to updated");
				if(DBOperation.updateGrade(sgh)) {
					System.out.println("Updated!!");
				}
			}
			else if(cho==3) {
				System.out.println("Please enter the student department that has to updated");
				if(DBOperation.updateDep(sgh)) {
					System.out.println("Updated!!");
				}
			}
			else if(cho==4) {
				System.out.println("Please enter the attendence percentage that has to updated");
				if(DBOperation2.updateAtt(sed)) {
					System.out.println("Updated!!");
				}
			}
			else if(cho==5) {
				System.out.println("Please enter the subject that has to updated");
				//String asub=sc.nextLine();
				if(DBOperation2.updateSub(sed)) {
					System.out.println("Updated!!");
				}
			}
			else {
				throw new InputInvalidException();
			}
		}
		else if(num==3) {
			System.out.println("Please enter the student id that has to deleted");
			int id=sc.nextInt();
			sed.setStudId(id);
			sgh.setStudId(id);
			if(DBOperation.delete(sgh) )
				System.out.println("student record deleted");
			else
				System.out.println("wrong input");
			if(DBOperation2.delete(sed))
				System.out.println("student exam record deleted");
			else 
				System.out.println("wrong input");
		}
		else if(num==4) {
			List<Student>list=new ArrayList<Student>();
			List<StudentExam>list1=new ArrayList<StudentExam>();
			list=DBOperation.displayDetails(sgh);
			System.out.println("Please enter the choice to display:\n1:Only Student details:\n2:Only Student Exam details:");
			List<Student>al=list.stream().sorted(( Comparator.comparingInt(a->((Student) a).getStudId()))).collect(Collectors.toList());
			int n=sc.nextInt();
			list1=DBOperation2.displayDetails(sed);
			List<StudentExam>la=list1.stream().sorted(( Comparator.comparingInt(a->((StudentExam) a).getStudId()))).collect(Collectors.toList());
			if(n==1) {
				System.out.printf("%-15s %-15s %-10s %-4s\n ","StudentId","StudentName","Grade","Department");
			
			al.forEach(e->
			System.out.printf("%-15s %-15s %-10s %-4s\n ",e.getStudId(),e.getStudName(),e.getStudGrade(),e.getStudDep())
			);}
			else if(n==2) {
				System.out.printf("%-15s %-15s  %-4s\n ","StudentId","Subject","Attendence Percentage");
				
				la.forEach(e->
				System.out.printf("%-15s %-15s  %-4s\n ",e.getStudId(),e.getSubject(),e.getAttendence())
				);}
			else {
				throw new InputInvalidException();
		}}
		else if(num==5) {
			System.out.println("Please enter the student id to display:");
			int did=sc.nextInt();
			//sgh.setStudId(did);
			DBOperation.displayOne(did);
		}
		else {
			throw new InputInvalidException();
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
