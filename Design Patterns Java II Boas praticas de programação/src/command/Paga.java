package command;

public class Paga implements Comando {

	private Pedido pedido;
	
	public Paga(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public void executa() {
		System.out.println("Pagando pedido " + pedido);
		
		pedido.paga();
	}
}
