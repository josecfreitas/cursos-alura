import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

	private final Connection connection;

	public ProdutoDAO(Connection connection) {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.connection = connection;
	}

	public void salva(Produto produto) throws SQLException {
		try (PreparedStatement st = connection.prepareStatement("insert into produto (nome, descricao) values (?,?)",
				Statement.RETURN_GENERATED_KEYS)) {
			st.setString(1, produto.getNome());
			st.setString(2, produto.getDescricao());
			st.execute();

			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				produto.setId(rs.getInt("id"));
			}

			rs.close();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.connection.rollback();
			System.out.println("rollback efetuado");
		}
	}

	public List<Produto> lista() {
		List<Produto> produtos = new ArrayList<>();

		try (Statement statement = connection.createStatement()) {
			statement.execute("select * from Produto");
			try (ResultSet rs = statement.getResultSet()) {

				while (rs.next()) {
					int id = rs.getInt("id");
					String nome = rs.getString("nome");
					String descricao = rs.getString("descricao");

					produtos.add(new Produto(id, nome, descricao));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return produtos;
	}
}
