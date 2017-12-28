package cap5;

public class ContaComum {

	private ManipuladorDeSaldo saldo;

    public ContaComum() {
        this.saldo = new ManipuladorDeSaldo();
    }

    public void deposita(double valor) {
    	saldo.deposita(valor);
    }

    public void saca(double valor) {
    	saldo.saca(valor);
    }

    public void rende() {
    	saldo.rende(1.01);
    }

    public double getSaldo() {
        return saldo.getSaldo();
    }
}
