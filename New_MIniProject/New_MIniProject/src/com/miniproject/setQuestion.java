package com.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import java.util.Scanner;
public class setQuestion extends Admin { 
	public void checkAvail(){
		Connection con=null;
		PreparedStatement ps=null;	
		ConnectionDB1 db=new ConnectionDB1();
		con=db.connectTo();
		Scanner sc=new Scanner(System.in);
	try {	
		int list[]=new int[11];
		int check[]=new int[list.length];
		int av[]=new int[list.length];
		boolean flag=false;
		try {
			ps=con.prepareStatement("select queNo from QueOpt");
			ResultSet rs=ps.executeQuery();
		 int count=1;
		 while(rs.next()&& count<11)  { 
		 				list[count]=rs.getInt(1);
		 				count++;
		 			}
			for(int i:list) {
				check[i]=1;}
			System.out.print("Available no.of Questions: ");
			for(int i=1;i<check.length;i++) {
				if(check[i]==0) {
					 av[i]=i;
					 System.out.print(i+"  ");	 
				}
			}
			System.out.println("  ");
			System.out.println("Enter question number:"); 
			int num=0;
			try {
			 num=sc.nextInt();}
			catch(Exception e) {
				System.out.println("Incorrect Input.");
				this.checkAvail();;
			}
			for(int i=1;i<av.length;i++) {
				if(av[i]==num) {
					 flag=true;
				}	
			}
			if(flag==true) {
				this.Question(num);}
		if (flag==false) {
				System.out.println("Question no. :"+num+" is not available.");
						this.reSetQue();
			}
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.checkAvail();
		}}
	catch(Exception e) {
		System.out.println(e);
		this.checkAvail();
	}finally {
		sc.close();
		try {
			con.close();
			ps.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	}
	public void Question(int num) {
		Connection con=null;
		PreparedStatement ps=null;	
		ConnectionDB1 db=new ConnectionDB1();
		con=db.connectTo();
		Scanner sc=new Scanner(System.in); 
		
		try {
		 
		System.out.println("Enter new question:");
		sc.nextLine();
		String que=sc.nextLine();
		System.out.println("Enter Option A:");
		String a="a. "+sc.nextLine();
		System.out.println("Enter Option B:");
		String b="b."+sc.nextLine();
		System.out.println("Enter Option C:");
		String c="c. "+sc.nextLine();
		System.out.println("Enter Option D:");
		String d="d. "+sc.nextLine();
		System.out.println("Enter Answer key for question:");
		String ans=sc.next();
		 
		 
			ps=con.prepareStatement("insert into QueOpt(queNo,que,option1,option2,option3,option4,answerkey)values(?,?,?,?,?,?,?)");
		ps.setInt(1, num);
		ps.setString(2, que);
		ps.setString(3, a);
		ps.setString(4, b);
		ps.setString(5, c);
		ps.setString(6, d);
		ps.setString(7, ans);
		ps.execute();
		System.out.println("Question added successfully.");
		this.reSetQue();
		 
		  } catch (SQLException e) {
			e.printStackTrace();
			this.checkAvail();;
		}finally {
			sc.close();
			try {
				con.close();
				ps.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}	
		  
		}
	public void reSetQue() {
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Enter another new question");
		System.out.println("2.back");
		int a=0;
		try {
		 a=sc.nextInt();}
		catch(Exception e) {
			System.out.println("Incorrect Input.");
			this.reSetQue();
		}
		switch(a) {
		case 1:
			this.checkAvail();;break;
		case 2:
			super.adminOption();
			default:
				System.out.println("Invalid input");
				this.reSetQue();
		} 
sc.close();	}
	
}
