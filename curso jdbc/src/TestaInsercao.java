import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		try (Connection connection = Database.getConnection()) {
			connection.setAutoCommit(false);

			String nome = "Notebook";
			String descricao = "Notebook i5";

			try (PreparedStatement st = connection.prepareStatement(
					"insert into produto (nome, descricao) values (?,?)", Statement.RETURN_GENERATED_KEYS)) {
				adiciona("TV LCD", "32 polegadas", st);
				adiciona("Blueray", "Full HDMI", st);
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
				System.out.println("rollback efetuado");
			}
		}
	}

	private static void adiciona(String nome, String descricao, PreparedStatement st) throws SQLException {
		if (nome.equals("Blueray")) {
			throw new IllegalArgumentException("Problema ocorrido");
		}
		st.setString(1, nome);
		st.setString(2, descricao);
		boolean resultado = st.execute();
		System.out.println(resultado);
		ResultSet rs = st.getGeneratedKeys();
		if (rs.next()) {
			System.out.println(rs.getInt("id"));
		}

		rs.close();
	}

}
