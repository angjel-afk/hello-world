package mk.codeacademy.java.db_start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
	private static String urlWithSchema = "jdbc:postgresql://localhost:5432/postgres?currentSchema=student";
	private static String user = "postgres";
	private static String password = "postgres";

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection(urlWithSchema, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT VERSION()")) {
			if (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(App.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}

	}
}