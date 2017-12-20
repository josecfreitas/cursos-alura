package command;

import java.util.ArrayList;
import java.util.List;

public class FilaDeTrabalho {

	private List<Comando> comandos;
	
	public FilaDeTrabalho() {
		comandos = new ArrayList<>();
	}
	
	public void adiciona(Comando comando) { 
		this.comandos.add(comando);
	}
	
	public void processa() {
		comandos.forEach(comando -> comando.executa());
	}
}
