package com.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Quiz extends MainPage {

	private int marks = 0;

	public void checkstudent() {
		Connection con = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		ConnectionDB1 ct = new ConnectionDB1();
		con = ct.connectTo();
		try {

			String name = "";
			int roll = 0;

			System.out.println("Enter name of Student");
			name = name + sc.next();
			System.out.println("Enter roll number:");
			try {
				roll = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Incorrect input");
				this.checkstudent();
			}
			ps = con.prepareStatement("insert into javastudent(Roll_num,name)values(?,?)");
			ps.setInt(1, roll);
			ps.setString(2, name);
			boolean flag = ps.execute();
			if (flag == false) {
				this.getQuestion(roll, name);
				
			}
		} catch (SQLException e) {
			System.out.println("Already given quiz.");
			this.back();
		} finally {
			sc.close();
			try {
				con.close();
				ps.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void getQuestion(int roll, String name) {
		Connection con = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		ConnectionDB1 ct = new ConnectionDB1();
		con = ct.connectTo();
		try {

			ps = con.prepareStatement(
					"select distinct que,option1,option2,option3,option4 ,answerkey from QueOpt order by rand()");
			ResultSet rs = ps.executeQuery();
			int queno = 1;
			while (rs.next() && queno < 11) {

				System.out.println(queno + ". " + rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println("Enter answer:");
				char a = sc.next().charAt(0);
				int c = Character.compare(a, rs.getString(6).charAt(0));
				if (c == 0) {
					marks++;
				}
				queno++;
			}
			ps.close();
			ps = con.prepareStatement("update javastudent set Marks=? where Roll_Num=?");
			ps.setInt(1, this.marks);
			ps.setInt(2, roll);
			ps.execute();
			System.out.println("Name of student : " + name + "" + " with Roll number: " + roll);
			System.out.println("Answers submitted successfully.");
			this.back();
			sc.close();
		} catch (Exception e) {
			System.out.println(e);
			this.checkstudent();
		} finally {
			sc.close();
			try {
				con.close();
				ps.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void back() {
		Scanner sc = new Scanner(System.in);
		int a = 0;
		System.out.println("1.Take quiz again.");
		System.out.println("2.Back");
		try {
			a = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Incorrect Input.");
			this.back();
		}
		switch (a) {
		case 1:
			this.checkstudent();
			;
			break;
		case 2:
			super.student();
			break;
		default:
			System.out.println("Invalid input");
			this.back();
		}
		sc.close();
	}

}
