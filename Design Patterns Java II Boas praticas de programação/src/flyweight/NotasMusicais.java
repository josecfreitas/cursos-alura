package flyweight;

import java.util.HashMap;
import java.util.Map;

import flyweight.nota.Do;
import flyweight.nota.Fa;
import flyweight.nota.La;
import flyweight.nota.Mi;
import flyweight.nota.Nota;
import flyweight.nota.Re;
import flyweight.nota.Si;
import flyweight.nota.Sol;

public class NotasMusicais {

	private static Map<String, Nota> notas = new HashMap<>();
	
	static {
		notas.put("do", new Do());
		notas.put("re", new Re());
		notas.put("mi", new Mi());
		notas.put("fa", new Fa());
		notas.put("sol", new Sol());
		notas.put("la", new La());
		notas.put("si", new Si());
	}
	
	public Nota pega(String nome) {
		return notas.get(nome);
	}
}
