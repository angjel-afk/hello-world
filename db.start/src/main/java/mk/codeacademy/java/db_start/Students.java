package mk.codeacademy.java.db_start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import java.sql.ResultSet;
import java.util.List;

import lombok.Value;

@Value
public class Students {
	private static String urlWithSchema = "jdbc:postgresql://localhost:5432/postgres?currentSchema=student";
	private static String user = "postgres";
	private static String password = "postgres";

	private int studentid;
	private String name;
	private String surname;
	private String email;
	private String phones;
	private int age;

	public Students(int studentid, String name, String surname, String email, String phones, int age) {
		this.studentid = studentid;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phones = phones;
		this.age = age;
	}

	public void students() {
		while (true) {
			System.out.println("Press 1 to get all tables");
			System.out.println("Press 2 to insert in the tables");
			Scanner x1 = new Scanner(System.in);
			int broj = x1.nextInt();
			if (broj == 1) {
				select();
			} else if (broj == 2) {
				System.out.println("studentid, name, surname, email, phones, age");
				Scanner x2 = new Scanner(System.in);
				int studentid = x2.nextInt();
				Scanner x3 = new Scanner(System.in);
				String name = x3.nextLine();
				Scanner x4 = new Scanner(System.in);
				String surname = x4.nextLine();
				Scanner x5 = new Scanner(System.in);
				String email = x5.nextLine();
				Scanner x6 = new Scanner(System.in);
				String phones = x6.nextLine();
				Scanner x7 = new Scanner(System.in);
				int age = x7.nextInt();
				insert(studentid, name, surname, email, phones, age);
			} else
				break;
		}
	}

	private static void select() {
		try (Connection con = DriverManager.getConnection(urlWithSchema, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM Students")) {
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getInt(6));
			}
			rs.close();
			st.close();
		} catch (SQLException ex) {
		}
	}

	private static void insert(int studentid, String name, String surname, String email, String phones, int age) {
		try (Connection con = DriverManager.getConnection(urlWithSchema, user, password);
				PreparedStatement preparedStatement = con.prepareStatement(
						"INSERT INTO student(studentid, firstname, lastname, email, age, city, courseid)"
								+ " VALUES (?,?,?,?,?,?,?) ")) {
			preparedStatement.setInt(1, studentid);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, surname);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, phones);
			preparedStatement.setInt(6, age);
			int row = preparedStatement.executeUpdate();
			System.out.println(row);
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
