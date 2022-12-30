package com.miniproject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CheckResult extends MainPage{

public  void check() {
	 Connection con=null;
	PreparedStatement ps=null;
 CallableStatement cs=null;
	
	Scanner sc=new Scanner(System.in);
	try {
	ConnectionDB1 db=new ConnectionDB1();
	con=db.connectTo();
	boolean flag=false;
	
	System.out.println("Enter roll number");
	int num=0;
	try {
 num=sc.nextInt();}
	catch(Exception e) {
		System.out.println("Incorrect input");
		this.check();
	}
	
	cs=con.prepareCall("Call Grade");
	cs.execute();
    ps=con.prepareStatement("Select name,marks,grade,Roll_num from JavaStudent where Roll_Num=?");
	 ps.setInt(1, num);
	 ResultSet rs=ps.executeQuery();
	 
	while(rs.next()) { 
		System.out.println("=========================================================");
		System.out.println("Result:");
	     System.out.println("name of student: "+rs.getString(1));
	     System.out.println("marks: "+rs.getInt(2));
	     System.out.println("Grade: "+rs.getString(3));
	     System.out.println("Roll number: "+rs.getInt(4));
	     flag=true;
	System.out.println("=========================================================");}
	if(flag==false) {
		System.out.println("invalid Roll number.Try again with right Roll number.");
	}
	 this.back();
	 sc.close();
	}
	catch(Exception e) {
		System.out.println(e);
		this.check();
	}	
	 finally{
			sc.close();
			try {
			con.close();
			ps.close();
			cs.close();
			 }
			catch(Exception e) {
				System.out.println(e);
			}
			}
	 
}	
public void back() { 
	Scanner sc=new Scanner(System.in);
	System.out.println("1.Check again.");
	System.out.println("2.Back");
	int opt=0;
	try {
	 opt=sc.nextInt();}
			catch(Exception e) {
				System.out.println("Incorrect input");
				this.back();
			}
	 
	switch(opt) {
	case 1:
		this.check();break;
	case 2:
		super.student();break;
		default: 
			System.out.println("Invalid input");
			this.back(); 
	}
sc.close();}
 
}
