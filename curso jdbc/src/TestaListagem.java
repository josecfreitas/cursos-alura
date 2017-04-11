import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		Connection connection = Database.getConnection();

		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("select * from Produto");
		ResultSet rs = statement.getResultSet();

		while (rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String descricao = rs.getString("descricao");

			System.out.println(id + ": " + nome + "(" + descricao + ")");
		}
		
		rs.close();
		statement.close();

		connection.close();
	}
}
