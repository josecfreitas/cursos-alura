package cap5;

public class ContaDeEstudante {

	private ManipuladorDeSaldo saldo;
    private int milhas;

    public void deposita(double valor) {
        saldo.deposita(valor);
        this.milhas += (int)valor;
    }

    public int getMilhas() {
        return milhas;
    }
}
