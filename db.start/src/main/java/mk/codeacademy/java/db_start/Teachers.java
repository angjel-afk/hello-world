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
public class Teachers {
	private static String urlWithSchema = "jdbc:postgresql://localhost:5432/postgres?currentSchema=student";
	private static String user = "postgres";
	private static String password = "postgres";

	private int teacherId;
	private int age;
	private String teacherName;

	public Teachers(int teacherId, int age, String teacherName) {
		this.teacherId = teacherId;
		this.age = age;
		this.teacherName = teacherName;
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
				System.out.println("teacherId, age, teacherName");
				Scanner x2 = new Scanner(System.in);
				int teacherId = x2.nextInt();
				Scanner x3 = new Scanner(System.in);
				int age = x3.nextInt();
				Scanner x4 = new Scanner(System.in);
				String teacherName = x4.nextLine();
				insert(teacherId, age, teacherName);
			} else
				break;
		}
	}

	private static void select() {
		try (Connection con = DriverManager.getConnection(urlWithSchema, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM Teachers")) {
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getInt(2));
				System.out.println(rs.getString(3));

			}
			rs.close();
			st.close();
		} catch (SQLException ex) {
		}
	}

	private static void insert(int teacherId, int age, String teacherName) {
		try (Connection con = DriverManager.getConnection(urlWithSchema, user, password);
				PreparedStatement preparedStatement = con.prepareStatement(
						"INSERT INTO student(studentid, firstname, lastname, email, age, city, courseid)"
								+ " VALUES (?,?,?,?,?,?,?) ")) {
			preparedStatement.setInt(1, teacherId);
			preparedStatement.setInt(2, age);
			preparedStatement.setString(3, teacherName);
			int row = preparedStatement.executeUpdate();
			System.out.println(row);
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
