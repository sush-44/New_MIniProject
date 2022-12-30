package com.miniproject;
import java.util.InputMismatchException;
import java.util.Scanner;
 interface MiniProject{
	 String wel="WELCOME to Mini Project ";
	 public void admin();
	 public void student();
	 
 }
public class MainPage implements MiniProject  {
	 Scanner sc=new Scanner(System.in);
	public void front() {
		
		  System.out.println(wel);
		  System.out.println("Please choose user from below:");
		  System.out.println("1.Admin .");
		  System.out.println("2.Student.");
		  Scanner sc=new Scanner(System.in);
		  int choice=0;
		  try {
		  choice=sc.nextInt();}
			catch(Exception e) {
				System.out.println("Incorrect input");
				this.front();
			}
		  switch(choice) {
		  case 1:
			  this.admin();;break;
		  case 2:
			  this.student();break;
			  default:
				  System.out.println("Enter valid action.");	
				  this.front();
		  }	sc.close();}
		
		
public static void main(String[] args) {
	MainPage mp=new MainPage();
	mp.front();
}
	
@Override
public void admin() {
	Admin ad=new Admin();
	ad.login();
}
	  
@Override
public void student() { 	
	Scanner sc=new Scanner(System.in);
	System.out.println("Choose options:");
	System.out.println("1.Take quiz.");
	System.out.println("2.check result .");
	System.out.println("3.Back .");
	int c=0;
	 
	try {	
	 c=sc.nextInt();}
	catch(InputMismatchException e) {
		System.out.println("Incorrect input");
		student();
	}
		if(c==1) {
		Quiz q=new Quiz();
		q.checkstudent(); }
		else if(c==2) {
		  CheckResult cr=new CheckResult();
		  cr.check();}
		else if(c==3) {
		this.front();}
		else {
			System.out.println("Invalid input");
		this.student();}sc.close();
	}}
	 
	 
	
 


