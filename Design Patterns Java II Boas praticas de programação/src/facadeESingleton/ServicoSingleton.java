package facadeESingleton;

public class ServicoSingleton {

	public static Servico instancia;
	
	public static Servico getInstancia(){
		if(instancia == null){
			instancia = new Servico();
		}
		
		return instancia;
	}
}
