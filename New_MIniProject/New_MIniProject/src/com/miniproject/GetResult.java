package com.miniproject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class GetResult extends Admin {
 
	 public void getResult() {
			  Connection connect=null;
			  PreparedStatement ps=null; 
			 CallableStatement cs=null;
			 ConnectionDB1 ct=new ConnectionDB1();
				connect=ct.connectTo();	
		
			try {
		 
			cs=connect.prepareCall("Call Grade");
			cs.execute();
			ps=connect.prepareStatement("Select Roll_num, name ,marks,grade from javastudent order by marks desc");
		ResultSet rs=ps.executeQuery();
		System.out.printf("%5s %8s %10s %8s","Roll Number","Name","Marks","Grade");
		System.out.println();
		System.out.println("---------------------------------------------------------");
		while(rs.next()) { 	
			System.out.format("%5s %15s %8s %8s",rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
			System.out.println();
			System.out.println("-------------------------------------------------------------");
		}	
		this.back();
		} catch (Exception e) {
			 	e.printStackTrace();
			 	super.adminOption();
		} finally{
			sc.close();
			try {
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
			int a=0;
			try {
			a=sc.nextInt();}
			catch(Exception e) {
				System.out.println("Incorrect input");
				this.back();
			}
			switch(a) {
			case 1:
				this.getResult();break;
			case 2:
				super.adminOption();break;
				default: 
					System.out.println("Invalid input");
					this.back(); 
			} sc.close();
	 }
	 }
	 
 
