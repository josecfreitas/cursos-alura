import java.util.HashMap;
import java.util.Map;

public class BalancoEmpresa {

	ArmazenadorDeDividas bd;
	public BalancoEmpresa(ArmazenadorDeDividas bd) {
		this.bd = bd;
	}

    public void registraDivida(Divida divida) {
        bd.salva(divida);
    }

    public void pagaDivida(Documento documentoCredor, Pagamento pagamento) {
        Divida divida = bd.carrega(documentoCredor);
        if (divida != null) {
            divida.registra(pagamento);
        }
        
        bd.salva(divida);
    }
}