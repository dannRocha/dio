package databaseconn;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionFactory {
	private ConnectionFactory() {
			throw new UnsupportedOperationException();
	}

	public static Connection getConnection() {

		Connection conn = null;

		try (FileInputStream input = new FileInputStream("./src/main/java/resources/connection.properties")) {
			
			Properties prop = new Properties();
			prop.load(input);

			String driver = prop.getProperty("jdbc.driver");
			String dbAddress = prop.getProperty("db.address");
			String dbName = prop.getProperty("db.name");
			String userDB = prop.getProperty("db.user.login");
			String passwordDB = prop.getProperty("db.user.password");

			StringBuilder buildURLConnection = new StringBuilder("jdbc:")
				.append(driver).append("://")
				.append(dbAddress).append("/")
				.append(dbName);

			String urlConnection = buildURLConnection.toString();

			try {
				conn = DriverManager.getConnection(urlConnection, userDB, passwordDB);
			}
			catch(SQLException e ) {
				e.printStackTrace();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
