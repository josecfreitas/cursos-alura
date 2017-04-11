import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		Connection con = Database.getConnection();
		Statement st = con.createStatement();
		
		st.execute("delete from Produto where id > 3");
		int count = st.getUpdateCount();
		System.out.println(count);
		
		st.close();
		con.close();
	}
}
