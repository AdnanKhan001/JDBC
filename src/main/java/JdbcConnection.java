import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "");

			System.out.println("connection established..");

			Statement sts = con.createStatement();
			ResultSet result = sts.executeQuery("select * from test");

			while (result.next()) {
				System.out.println(result.getInt(1) + ", " + result.getString(2) + ", " + result.getString(3));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("not able to create connection.." + e.getMessage());
		}
	}
}
