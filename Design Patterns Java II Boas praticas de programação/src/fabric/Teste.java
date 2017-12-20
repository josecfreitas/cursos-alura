package fabric;

import java.sql.Connection;

public class Teste {

	public static void main(String[] args) {
		Connection c = new ConnectionFabric().getConnection();
	}
}
