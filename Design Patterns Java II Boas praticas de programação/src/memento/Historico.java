package memento;

import java.util.ArrayList;
import java.util.List;

public class Historico {

	List<Estado> estadosSalvos = new ArrayList<>();
	
	public Estado pega(int index){
		return estadosSalvos.get(index);
	}
	
	public void adiciona(Estado estado) {
		estadosSalvos.add(estado);
	}
}
