package bridgesEAdapters;

public class Testa {

	public static void main(String[] args) {
//		Bridge
		Mapa mapa = new GoogleMaps();
		System.out.println(mapa.devolveMapa("teste"));
		
		//Adpter
		Relogio relogio = new RelogioDoSistema();
		System.out.println(relogio.hoje());
	}
}
