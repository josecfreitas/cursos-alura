import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Pagamentos implements Iterable<Pagamento> {

    private double valorPago;
    private List<Pagamento> pagamentos = new ArrayList<>();

	public Collection<Pagamento> pagamentosAntesDe(Calendar data) {
        ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
        for (Pagamento pagamento : this) {
            if (pagamento.getData().before(data)) {
                pagamentosFiltrados.add(pagamento);
            }
        }
        return pagamentosFiltrados;
    }
    public Collection<Pagamento> pagamentosComValorMaiorQue(double valorMinimo) {
        ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
        for (Pagamento pagamento : this) {
            if (pagamento.getValor() > valorMinimo) {
                pagamentosFiltrados.add(pagamento);
            }
        }
        return pagamentosFiltrados;
    }
    public Collection<Pagamento> pagamentosDo(String cnpjPagador) {
        ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
        for (Pagamento pagamento : this) {
            if (pagamento.getCnpjPagador().equals(cnpjPagador)) {
                pagamentosFiltrados.add(pagamento);
            }
        }
        return pagamentosFiltrados;
    }

    public void registra(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
        paga(pagamento.getValor());
    }

    public double getValorPago() {
        return this.valorPago;
    }
    private void paga(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor invalido para pagamento");
        }
        if (valor > 100) {
            valor = valor - 8;
        }
        this.valorPago += valor;
    }
    
	@Override
	public Iterator<Pagamento> iterator() {
		return this.pagamentos.iterator();
	}
}
