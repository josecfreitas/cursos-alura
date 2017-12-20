package command;

public class Testa {

	public static void main(String[] args) {
		Pedido pedido1 = new Pedido("José Carlos", 100);
		Pedido pedido2 = new Pedido("Gabriel", 200);
		
		FilaDeTrabalho filaDeTrabalho = new FilaDeTrabalho();
		
		filaDeTrabalho.adiciona(new Paga(pedido1));
		filaDeTrabalho.adiciona(new Paga(pedido2));
		filaDeTrabalho.adiciona(new ConcluiPedido(pedido1));
		
		filaDeTrabalho.processa();
	}
	
}
