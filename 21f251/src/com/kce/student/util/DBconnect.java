package com.kce.student.util;
import java.sql.*;
import java.sql.DriverManager;

public class DBconnect {
public static Connection getConnect()
{
	Connection con=null;
	try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SELVAKUMAR","selva2213");

	}
	catch(SQLException sq) {
		System.out.println(sq);
	}
	catch(ClassNotFoundException cf) {
		System.out.println(cf);
	}
	return con;
}
public static void main(String[] args) {
	getConnect();
	System.out.println("connected");
}
}
