package design.patterns.chain.of.responsability.exercício;

public class Testa {

	public static void main(String[] args) {
		Investidor conservador = new Conservador();
		Investidor moderado = new Moderado();
		Investidor arrojado = new Arrojado();
		
		Conta conta = new Conta("José Carlos", 100);
		
		RealizadorDeInvestimento realizadorDeInvestimento = new RealizadorDeInvestimento();
		
		realizadorDeInvestimento.investir(conta, arrojado);

		Requisicao csv = new Requisicao(Formato.CSV);
		Requisicao Porcento = new Requisicao(Formato.PORCENTO);
		Requisicao xml = new Requisicao(Formato.XML);

		Resposta resposta = new RespostaCsv(new RespostaPorcento(new RespostaXml(new SemResposta())));
		
		System.out.println(resposta.responde(csv, conta));
		
		System.out.println("saldo: " + conta.getValor());
	}
	
}
