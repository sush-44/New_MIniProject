package com.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DisplayQue extends Admin{
 
	public void display() {
		Connection con=null;
		PreparedStatement ps=null;
		ConnectionDB1 db=new ConnectionDB1();
		con=db.connectTo();
	 
		try {
			ps=con.prepareStatement("select queNo,que,option1,option2,option3,option4 ,answerkey from QueOpt");
		ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"  ");
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println("Answerkey: "+rs.getString(7));
				System.out.println("=============================");
			}
			this.back();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.display();
		}
		 finally{
				sc.close();
				try {
				ps.close();
				 }
				catch(Exception e) {
					System.out.println(e);
				}
				}
	}

	public void deleteQue() {
		Scanner sc=new Scanner(System.in);
		Connection con=null;
		PreparedStatement ps=null;
		ConnectionDB1 db=new ConnectionDB1();
		con=db.connectTo();
		try {
		con=db.connectTo();
		System.out.println("Enter question no.");
		int num=0;
		try {
	 num=sc.nextInt();}
		catch(Exception e) {
			System.out.println("Incorrect input");
			this.deleteQue();
		}
		
			ps=con.prepareStatement("delete from QueOpt where queNo=?");
			ps.setInt(1, num);
			ps.execute();
			System.out.println("Question no.:"+num+" deleted.");
			
			this.back1();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.deleteQue();
		}	
		 finally{
				sc.close();
				try {
				ps.close();
				 }
				catch(Exception e) {
					System.out.println(e);
				}
				}
	}
	public void back() {
		Scanner sc=new Scanner(System.in);
		System.out.println("back(y/n)");
		char a=sc.next().charAt(0);
		if(a=='y') {
			Admin ad=new Admin();
			ad.adminOption();
		}
		else {
			System.out.println("Please enter y(yes) or n(No).");
			this.back();
		} 
		sc.close();
	}
	public void back1() {
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Delete another question.");
		System.out.println("2.Back.");
		int a=0;
		try {
		 a=sc.nextInt();}
		catch(Exception e) {
			System.out.println("Incorrect input");
			this.back1();
		}
		 switch(a) {
		 case 1:
			 this.deleteQue(); break;
		 case 2:
			 Admin ad=new Admin();
				ad.adminOption(); break;
		default:
			System.out.println("Invalid input.");
				this.back1();					
		}
sc.close();	} 
	}		

