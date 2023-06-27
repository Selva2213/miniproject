package com.kce.student.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kce.student.bean.Student;
import com.kce.student.util.DBconnect;
 
public class DBOperation {
	static PreparedStatement ps;
	 static Connection con=DBconnect.getConnect();
	 static ResultSet rs;
	 static Statement st;
	 static Scanner sc=new Scanner(System.in);
	static Student s1=new Student();
	public static boolean insertion(Student sgh) {
		try {
			ps=con.prepareStatement("select StudentId from Student_Details");
			 rs=ps.executeQuery();
			int c=0;
			while(rs.next())
			{
				if(rs.getInt(1)==sgh.getStudId()) {
					c++;
				}
					
			}
			if(c==0) {
		ps=con.prepareStatement("insert into Student_Details values(?,?,?,?)");
		ps.setInt(1, sgh.getStudId());
		ps.setString(2, sgh.getStudName());
		ps.setString(3,sgh.getStudGrade());
		ps.setString(4, sgh.getStudDep());
		ps.execute();
		return true;
		}
			else return false;
		}
		catch(SQLException sq)
		{
			sq.printStackTrace();
		}
		return false;
	}
	public static boolean delete(Student s1) {
		try {
		ps=con.prepareStatement("delete from Student_Details where StudentId=?");
		ps.setInt(1,s1.getStudId());
		ps.execute();
		return true;
		}
		catch(SQLException sq) {
			sq.printStackTrace();
		}
		return false;
	}
	public static boolean updateName(Student s1) {
		try {
			String altname=sc.nextLine();
			 ps=con.prepareStatement("update  Student_Details set StudentName=? where StudentId=?");
			ps.setString(1, altname);
			ps.setInt(2, s1.getStudId());
			ps.execute();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public static boolean updateGrade(Student s1) {
		try {
			String gr=sc.next();
			 ps=con.prepareStatement("update  Student_Details set StudentGrade=? where StudentId=?");
			ps.setString(1, gr);
			ps.setInt(2, s1.getStudId());
			ps.execute();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public static boolean updateDep(Student s1) {
		try {
			String dp=sc.nextLine();
			 ps=con.prepareStatement("update  Student_Details set StudentDepartment=? where StudentId=?");
			ps.setString(1, dp);
			ps.setInt(2, s1.getStudId());
			ps.execute();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public static void displayOne(int did) {
		try {
		ps=con.prepareStatement("select StudentId,StudentName,StudentGrade,StudentDepartment,Attendence_Per,Exam_Subject from Student_Details natural join Student_Exam_Details where StudentId=?");
		ps.setInt(1, did);
		rs=ps.executeQuery();
		System.out.printf("%-15s %-15s %-10s %-15s %-25s %-10s\n ","StudentId","StudentName","Grade","Department","Attendence Percentage","Subject");
		if(rs.next()) {
			System.out.printf("%-15s %-15s %-10s %-15s %-25s %-20s\n ",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getString(6));

		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public  static List<Student> displayDetails(Student sgh){
		try {
			Statement sts=con.createStatement();
			 rs=sts.executeQuery("select * from Student_Details ");
			System.out.println("Student details:....\n\n");
			List<Student> al=new ArrayList<Student>();
			while(rs.next())
			{
				int tid=rs.getInt(1);
				String tname=rs.getString(2);
				String tgrade=rs.getString(3);
				String tdep=rs.getString(4);
				al.add(new Student(tid,tname,tgrade,tdep));
				
			}
			return al;
		}
		catch(SQLException sq) {
			sq.printStackTrace();
		}
		return null;
	}
}
