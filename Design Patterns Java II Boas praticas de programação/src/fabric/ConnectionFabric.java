package fabric;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFabric {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("string do banco", "root", "senha");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
