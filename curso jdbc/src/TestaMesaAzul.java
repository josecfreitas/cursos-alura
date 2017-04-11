import java.sql.Connection;
import java.sql.SQLException;

public class TestaMesaAzul {

	public static void main(String[] args) throws SQLException {
		Produto produto = new Produto("Mesa azul", "Mesa com 4 pés");
		
		try(Connection connection = Database.getConnection()){
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			
			produtoDAO.salva(produto);
			for(Produto p : produtoDAO.lista()){
				System.out.println(String.format("%d: %s (%s)", p.getId(), p.getNome(), p.getDescricao()));
			}
		}
	}
}
