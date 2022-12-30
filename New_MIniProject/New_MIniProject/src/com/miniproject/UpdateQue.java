package com.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateQue extends Admin  { 
 
	public void Update() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("please choose option for update:");
		System.out.println("1.whole question.");
		System.out.println("2.Only Options.");
		System.out.println("3.Answer key of question.");
		System.out.println("4.Back");
		int val=0;
		try {
		 val=sc.nextInt();}
		catch(Exception e) {
			System.out.println("Incorrect Input.");
			this.Update();
		}
		switch(val) {
		case 1:
			this.updateQue();break;
		case 2:
			this.updateOpt();
		case 3:
			this.updateAns();break;
		case 4:
			super.adminOption();break;
			default:
				System.out.println("Invalid input");
				this.Update();
		} 
	sc.close();
	}
public void updateQue() {
	Connection con=null;
	PreparedStatement ps=null;
	ConnectionDB1 db=new ConnectionDB1();
	Scanner s1=new Scanner(System.in);
try {
	con=db.connectTo();
 
	 System.out.println("Enter question no.:");
	 int no=0;
	 try {
	  no=s1.nextInt();}
	 catch(Exception e) {
			System.out.println("Incorrect Input.");
			this.updateQue();
		}
    System.out.println("Enter new question:");
       s1.nextLine();
       String q=sc.nextLine();
   	String a="a.";
   	String b="b.";
   	String c="c.";
   	String d="d.";
   
   	System.out.println("Enter Option A:");
   	 
    a=a+s1.nextLine();
   	System.out.println("Enter Option B:");
   	 b=b+s1.nextLine();
   	 System.out.println("Enter Option C:");
   	 c=c+s1.nextLine(); 
   	 System.out.println("Enter Option D:");
   	 d=d+s1.nextLine();
 	 System.out.println("Enter Answer key:");
   	  String ans=sc.nextLine();
   	ps=con.prepareStatement(" update QueOpt set que=?, option1=?,option2=?,option3=?,option4=? ,answerkey =? where queNo=?");
   	ps.setString(1,q);
   	ps.setString(2,a);
   	ps.setString(3,b);
   	ps.setString(4,c);
   	ps.setString(5,d);
   	ps.setString(6,ans);
   	ps.setInt(7, no);
   	
   	ps.execute();
   	System.out.println(" Question no."+no+" updated successfully.");
   	this.reUpdateQue();
s1.close();
  } catch (Exception e) {
	e.printStackTrace();
	this.Update();
} finally{
	sc.close();
	try {
	con.close();
	ps.close();
	
	 }
	catch(Exception e) {
		System.out.println(e);
	}
	}
}
public void updateOpt() {
	Connection con=null;
	PreparedStatement ps=null;
	ConnectionDB1 db=new ConnectionDB1();
	Scanner s2=new Scanner(System.in);
	try {
	con=db.connectTo();
	 System.out.println("Enter question no.:");
	 int no=0;
	 try {
	 no=s2.nextInt();}
	 catch(Exception e) {
			System.out.println("Incorrect Input.");
			this.updateOpt();
		}
	 
		ps=con.prepareStatement("select que from QueOpt where queNo=?");
		ps.setInt(1, no);
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		System.out.println("Question: "+rs.getString(1));
	}
	String a="a.";
	String b="b.";
	String c="c.";
	String d="d.";
	System.out.println("Enter values:");
	System.out.println("Enter Option A:");
 
 a=a+s2.nextLine();
	System.out.println("Enter Option B:");
	 b=b+s2.nextLine();
	 System.out.println("Enter Option C:");
	 c=c+s2.nextLine(); 
	 System.out.println("Enter Option D:");
	 d=d+s2.nextLine();
	ps=con.prepareStatement("update QueOpt set option1=?,option2=?,option3=?,option4=? where queNo=?");
	ps.setString(1,a);
	ps.setString(2,b);
	ps.setString(3,c);
	ps.setString(4,d);
	ps.setInt(5,no);
	ps.execute();
	System.out.println("Options updated successfully");
	this.reUpdateQue();
	 s2.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		this.Update();
	}
	 finally{
			sc.close();
			try {
			con.close();
			 }
			catch(Exception e) {
				System.out.println(e);
			}
			}
}
public void updateAns() {
	Connection con=null;
	PreparedStatement ps=null;
	ConnectionDB1 db=new ConnectionDB1();
	Scanner s3=new Scanner(System.in);
	 try {
	con=db.connectTo();
	 System.out.println("Enter question no.:");
	 int no=0;
	 try {
	 no=s3.nextInt();}
	 catch(Exception e) {
			System.out.println("Incorrect Input.");
			this.updateAns();;
		}
	
		ps=con.prepareStatement("select que,option1,option2,option3,option4 from QueOpt where queNo=?");
		ps.setInt(1, no);
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		System.out.println("Question: "+rs.getString(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getString(3));
		System.out.println(rs.getString(4));
		System.out.println(rs.getString(5));
	}
	ps=con.prepareStatement("update  QueOpt set answerkey=? where queNo=?;");
	System.out.println("Enter Answer Key:");
	String ans=s3.next();
	ps.setString(1, ans);
	ps.setInt(2, no);
	ps.execute();
	System.out.println("Answer key updated Successfully");
	this.reUpdateQue();
	s3.close();
	 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.Update();
		}
	 finally{
			sc.close();
			try {
			con.close();
			 }
			catch(Exception e) {
				System.out.println(e);
			}
			}
	}
 
		
public void reUpdateQue() { 
	Scanner s4=new Scanner(System.in);
	System.out.println("1.Update another question");
	System.out.println("2.back");
	int a=0;
	try {
	 a=s4.nextInt();}
	catch(Exception e) {
		System.out.println("Incorrect Input.");
		this.reUpdateQue();;
	}
	switch(a) {
	case 1:
		this.Update(); 
	case 2:
	    super.adminOption();
	    default:
	    	System.out.println("Invalid input");
	    	this.reUpdateQue();
	} 
	s4.close();
	}	

}
