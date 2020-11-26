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
public class Phones {
	private static String urlWithSchema = "jdbc:postgresql://localhost:5432/postgres?currentSchema=student";
	private static String user = "postgres";
	private static String password = "postgres";

	private int phoneid;
	private String phone;
	private int studentid;

	public Phones(int phoneid, String phone, int studentid) {
		this.phoneid = phoneid;
		this.phone = phone;
		this.studentid = studentid;
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
				System.out.println("phoneid, phone, studentid");
				Scanner x2 = new Scanner(System.in);
				int phoneid = x2.nextInt();
				Scanner x3 = new Scanner(System.in);
				String phone = x3.nextLine();
				Scanner x4 = new Scanner(System.in);
				int studentid = x4.nextInt();
				insert(phoneid, phone, studentid);
			} else
				break;
		}
	}

	private static void select() {
		try (Connection con = DriverManager.getConnection(urlWithSchema, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM Phones")) {
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));

			}
			rs.close();
			st.close();
		} catch (SQLException ex) {
		}
	}

	private static void insert(int phoneid, String phone, int studentid) {
		try (Connection con = DriverManager.getConnection(urlWithSchema, user, password);
				PreparedStatement preparedStatement = con.prepareStatement(
						"INSERT INTO phones(phoneid, phone, studentid)" + " VALUES (?,?,?,?,?,?,?) ")) {
			preparedStatement.setInt(1, phoneid);
			preparedStatement.setString(2, phone);
			preparedStatement.setInt(3, studentid);
			int row = preparedStatement.executeUpdate();
			System.out.println(row);
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
