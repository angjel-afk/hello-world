package mk.codeacademy.java.db_start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.ResultSet;

import lombok.Value;

@Value
public class Courses {
	private static String urlWithSchema = "jdbc:postgresql://localhost:5432/postgres?currentSchema=student";
	private static String user = "postgres";
	private static String password = "postgres";

	private int courseId;
	private int price;
	private String description;
	private int programId;
	private String startDate;

	public Courses(int courseId, int price, String description, int programId, String startDate) {
		this.courseId = courseId;
		this.price = price;
		this.description = description;
		this.programId = programId;
		this.startDate = startDate;
	}

	public void teacher() {
		while (true) {
			System.out.println("Press 1 to get all tables");
			System.out.println("Press 2 to insert in the tables");
			Scanner x1 = new Scanner(System.in);
			int broj = x1.nextInt();
			if (broj == 1) {
				select();
			} else if (broj == 2) {
				System.out.println("courseId, price, description, programId, startDate");
				Scanner x2 = new Scanner(System.in);
				int courseId = x2.nextInt();
				Scanner x3 = new Scanner(System.in);
				int price = x3.nextInt();
				Scanner x4 = new Scanner(System.in);
				String description = x4.nextLine();
				Scanner x5 = new Scanner(System.in);
				int programId = x5.nextInt();
				Scanner x6 = new Scanner(System.in);
				String startDate = x6.nextLine();
				insert(courseId, price, description, programId, startDate);
			} else
				break;
		}
	}

	private static void select() {
		try (Connection con = DriverManager.getConnection(urlWithSchema, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM Courses")) {
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getInt(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
				System.out.println(rs.getString(5));

			}
			rs.close();
			st.close();
		} catch (SQLException ex) {
		}
	}

	private static void insert(int courseid, int price, String description, int programId, String startDate) {
		try (Connection con = DriverManager.getConnection(urlWithSchema, user, password);
				PreparedStatement preparedStatement = con.prepareStatement(
						"INSERT INTO student(studentid, firstname, lastname, email, age, city, courseid)"
								+ " VALUES (?,?,?,?,?,?,?) ")) {
			preparedStatement.setInt(1, courseid);
			preparedStatement.setInt(2, price);
			preparedStatement.setString(3, description);
			preparedStatement.setInt(4, programId);
			preparedStatement.setString(5, startDate);
			int row = preparedStatement.executeUpdate();
			System.out.println(row);
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}