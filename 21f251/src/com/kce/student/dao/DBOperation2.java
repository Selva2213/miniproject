package com.kce.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kce.student.bean.StudentExam;
import com.kce.student.util.DBconnect;

public class DBOperation2 {
	static PreparedStatement ps1;
	 static Connection conn=DBconnect.getConnect();
	 static ResultSet rs1;
	 static Scanner sc=new Scanner(System.in);
	public static boolean insertion(StudentExam sed) {
		try {
		 ps1=conn.prepareStatement("insert into Student_Exam_Details values(?,?,?)");
//		 System.out.println(sed.get());
		ps1.setInt(1, sed.getStudId());
		ps1.setFloat(2, sed.getAttendence());
		ps1.setString(3,sed.getSubject());
		ps1.execute();
		return true;
		}
		catch(SQLException sq)
		{
			sq.printStackTrace();
		}
		return false;
	}
	public static boolean delete(StudentExam sed) {
		try {
		 ps1=conn.prepareStatement("delete from Student_Exam_Details where StudentId=?");
		ps1.setInt(1,sed.getStudId());
		ps1.execute();
		return true;
		}
		catch(SQLException sq) {
			sq.printStackTrace();
		}
		return false;
	}
	public static boolean updateSub(StudentExam sed) {
		try {
			String str=sc.nextLine();
			 ps1=conn.prepareStatement("update  Student_Exam_Details set Exam_Subject=? where StudentId=?");
			ps1.setString(1, str);
			ps1.setInt(2, sed.getStudId());
			ps1.execute();
			return true;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public static boolean updateAtt(StudentExam sed) {
		try {
			float fg=sc.nextFloat();
			 ps1=conn.prepareStatement("update  Student_Exam_Details set Attendence_Per=? where StudentId=?");
			ps1.setFloat(1, fg);
			ps1.setInt(2, sed.getStudId());
			ps1.execute();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public static List<StudentExam> displayDetails(StudentExam sed){
		try {
			Statement sts=conn.createStatement();
			 rs1=sts.executeQuery("select * from Student_Exam_Details");
			System.out.println("Student Exam details:....");
			List<StudentExam>list1=new ArrayList<StudentExam>();
			while(rs1.next())
			{
				int tid=rs1.getInt(1);
				float f=rs1.getFloat(2);
				String sub=rs1.getString(3);
				sed.setAttendence(f);
				sed.setSubject(sub);
				sed.setStudId(tid);
				System.out.println(rs1.getString(3));
				list1.add(new StudentExam(tid,f,sub));
			}
			return list1;
		}
		catch(SQLException sq) {
			sq.printStackTrace();
		}
		return null;
	}
	
}
