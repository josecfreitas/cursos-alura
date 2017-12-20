package flyweight;

import java.util.Arrays;
import java.util.List;

import flyweight.nota.Nota;

public class Testa {

	public static void main(String[] args) {

		NotasMusicais notas = new NotasMusicais();

		List<Nota> musica = Arrays.asList(
				notas.pega("do"),    
	            notas.pega("re"),    
	            notas.pega("mi"),    
	            notas.pega("fa"),    
	            notas.pega("fa"),    
	            notas.pega("fa"),    

	            notas.pega("do"),    
	            notas.pega("re"),    
	            notas.pega("do"),    
	            notas.pega("re"),    
	            notas.pega("re"),    
	            notas.pega("re"),

	            notas.pega("do"),    
	            notas.pega("sol"),    
	            notas.pega("fa"),    
	            notas.pega("mi"),    
	            notas.pega("mi"),    
	            notas.pega("mi"),

	            notas.pega("do"),    
	            notas.pega("re"),    
	            notas.pega("mi"),    
	            notas.pega("fa"),    
	            notas.pega("fa"),    
	            notas.pega("fa"),
				
				
				notas.pega("do"),
				notas.pega("do"),
				notas.pega("sol"),
				notas.pega("sol"),
				notas.pega("la"),
				notas.pega("la"),
				notas.pega("sol"),
				notas.pega("sol"),
				notas.pega("fa"),
				notas.pega("fa"),
				notas.pega("mi"),
				notas.pega("mi"),
				notas.pega("re"),
				notas.pega("re"),
				notas.pega("do"),
				
				notas.pega("sol"),
				notas.pega("sol"),
				notas.pega("fa"),
				notas.pega("fa"),
				notas.pega("mi"),
				notas.pega("mi"),
				notas.pega("re"),
				notas.pega("re"),
				notas.pega("sol"),
				notas.pega("sol")
		);
		
		new Piano().toca(musica);
	}
}
