package com.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
 
 
public class Admin extends MainPage {
	 	 
		public void login() {
			Connection con=null;
	 
			Scanner sc=new Scanner(System.in);
			try {
			ConnectionDB1 db=new ConnectionDB1();
			con=db.connectTo();
			System.out.print("1.Admin Log in   ");
			System.out.println("2.Admin Sign Up");
			System.out.println("3.Back");
			int a=0;
			try {
			 a=sc.nextInt();}
			catch(Exception e) {
				System.out.println("Incorrect input");
				this.login();
			}
			switch(a) {
			case 1:
				this.logIn();break;
			case 2:
				this.signUp();break;
			case 3:
				super.front();break;
				default:
					System.out.println("Invalid Input");
					login();
			}
		}catch (Exception e) {
				System.out.println("Incorrect input");
			login();
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
		
	public void logIn() {
		Scanner sc=new Scanner(System.in);
		Connection con=null;
		PreparedStatement ps=null;	
		ConnectionDB1 db=new ConnectionDB1();
		con=db.connectTo();
		try {
		System.out.println("Enter User ID:");
		String id=sc.next();
		System.out.println("Enter password:");
		String pwd=sc.next();
	boolean flag=false;
			ps=con.prepareStatement("select UserID,Password from Admin" );
			ResultSet rs=ps.executeQuery();
			while(rs.next()) { 
				if (rs.getString(1).equals(id) && rs.getString(2).equals(pwd) ){
			                   flag=true;						
				 
				}}
			if(flag==true) {
				this.adminOption();
			}
			if(flag==false) {
				System.out.println("Invalid userID and password.");
				this.login();
			}
			
			sc.close();}  
		catch (Exception e) {
			 e.printStackTrace();
			logIn();
		}
		 finally{
				sc.close();
				try {
				con.close();
				ps.close();}
				catch(Exception e) {
					System.out.println(e);
				}
				}
	}
	public void adminOption(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose option from below:");	
		System.out.println("1.Enter new Question,Options and Answerkey.");	
		System.out.println("2.Update Question,Options and Answerkey.");
		System.out.println("3.Get result of all students.");
		System.out.println("4.View all questions.");
		System.out.println("5.Delete Question.");	
		System.out.println("6.Back ");
		int val=0;
		try {
		 val=sc.nextInt();}
		catch(Exception e) {
			System.out.println("Incorrect input");
			this.adminOption();
		}
		 
		switch(val) {
		case 1: 
			setQuestion sq=new setQuestion();
			sq.checkAvail();
		case 2:
			UpdateQue uq=new UpdateQue();
			uq.Update();
		case 3:
			GetResult gr=new GetResult();
			gr.getResult();
		case 4:
			DisplayQue dq=new DisplayQue();
			dq.display();
		case 5:
			DisplayQue dq1=new DisplayQue();
			dq1.deleteQue();
		case 6:
			super.front();
			default :
				System.out.println("Invalid Input.");
				this.adminOption();
			}
		sc.close();}
	
			public void signUp() {
				Connection con=null;
				PreparedStatement ps=null;	
				ConnectionDB1 db=new ConnectionDB1();
				con=db.connectTo();
				Scanner sc=new Scanner(System.in);
				try {
		System.out.println("Enter User ID:");
		String id=sc.next();
		System.out.println("Enter password:");
		String pwd=sc.next();
	
			ps=con.prepareStatement("insert into Admin(UserID,Password)values(?,?)");
			ps.setString(1,id);
			ps.setString(2,pwd);
			ps.execute();
			System.out.println("Sign up successefully.");
			this.back();
		sc.close();
		} catch (Exception e) {
			System.out.println(e);
			signUp();
		}	
				 finally{
						sc.close();
						try {
						con.close();
						ps.close();}
						catch(Exception e) {
							System.out.println(e);
						}
						}
	}
		 public void back() {
			 Scanner sc=new Scanner(System.in);
			 System.out.println("1.Sign up again");
				System.out.println("2.back");
				int a=0;
				try {
				 a=sc.nextInt();}
				catch(Exception e) {
					System.out.println("Incorrect input");
					this.back();
				}
				switch(a) {
				case 1:
					this.signUp();
				case 2:
					super.admin();
					default:
						System.out.println("Invalid input");
						back();		
				}	 
	sc.close();	 } 
		 }
		
