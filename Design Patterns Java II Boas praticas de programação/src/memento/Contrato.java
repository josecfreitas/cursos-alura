package memento;

import java.util.Calendar;

public class Contrato {

	private Calendar data;
	private String cliente;
	private TipoContrato tipo;
	
	private Historico historico;
	
	public Contrato(Calendar data, String cliente, TipoContrato tipo) {
		this.data = data;
		this.cliente = cliente;
		this.tipo = tipo;
		
		historico = new Historico();
	}

	public Calendar getData() {
		return data;
	}

	public String getCliente() {
		return cliente;
	}

	public TipoContrato getTipo() {
		return tipo;
	}
	
	public void avanca(){
		salvaEstado();
		
		if(tipo == TipoContrato.NOVO) tipo = TipoContrato.EM_ANDAMENTO;
		else if(tipo == TipoContrato.EM_ANDAMENTO) tipo = TipoContrato.ACERTADO;
		else if(tipo == TipoContrato.ACERTADO) tipo = TipoContrato.CONCLUIDO;
	}
	
	private void salvaEstado() {
		historico.adiciona(new Estado(new Contrato(data, cliente, tipo)));
	}

	public Estado pega(int index){
		return historico.pega(index);
	}
}
