package mk.codeacademy.java.db_start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import lombok.Value;

@Value
public class Programs {
	private static String urlWithSchema = "jdbc:postgresql://localhost:5432/postgres?currentSchema=student";
	private static String user = "postgres";
	private static String password = "postgres";

	private int programId;
	private String name;
	private int price;
	private String duration;
	private int startDate;
	private int teacherId;

	public Programs(int programId, String name, int price, String duration, int startDate, int teacherId) {
		this.programId = programId;
		this.name = name;
		this.price = price;
		this.duration = duration;
		this.startDate = startDate;
		this.teacherId = teacherId;
	}

	public void program() {
		while (true) {
			System.out.println("Press 1 to get all tables");
			System.out.println("Press 2 to insert in the tables");
			Scanner x1 = new Scanner(System.in);
			int broj = x1.nextInt();
			if (broj == 1) {
				select();
			} else if (broj == 2) {
				System.out.println("programId, name, price, duration, startDate, teacherId");
				Scanner x2 = new Scanner(System.in);
				int programId = x2.nextInt();
				Scanner x3 = new Scanner(System.in);
				String name = x3.nextLine();
				Scanner x4 = new Scanner(System.in);
				int price = x4.nextInt();
				Scanner x5 = new Scanner(System.in);
				String duration = x5.nextLine();
				Scanner x6 = new Scanner(System.in);
				int startDate = x6.nextInt();
				Scanner x7 = new Scanner(System.in);
				int teacherId = x7.nextInt();
				insert(programId, name, price, duration, startDate, teacherId);
			} else
				break;
		}
	}

	private static void select() {
		try (Connection con = DriverManager.getConnection(urlWithSchema, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM Programs")) {
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getInt(5));
				System.out.println(rs.getInt(6));
			}
			rs.close();
			st.close();
		} catch (SQLException ex) {
		}
	}

	private static void insert(int programId, String name, int price, String duration, int startDate, int teacherId) {
		try (Connection con = DriverManager.getConnection(urlWithSchema, user, password);
				PreparedStatement preparedStatement = con.prepareStatement(
						"INSERT INTO student(studentid, firstname, lastname, email, age, city, courseid)"
								+ " VALUES (?,?,?,?,?,?,?) ")) {
			preparedStatement.setInt(1, programId);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, price);
			preparedStatement.setString(4, duration);
			preparedStatement.setInt(5, startDate);
			preparedStatement.setInt(6, teacherId);
			int row = preparedStatement.executeUpdate();
			System.out.println(row);
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
