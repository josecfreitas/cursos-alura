package design.patterns.chain.of.responsability.exercício;

public class RespostaCsv implements Resposta {

	private Resposta proxima;
	
	public RespostaCsv(Resposta proxima) {
		super();
		this.proxima = proxima;
	}

	@Override
	public String responde(Requisicao requisicao, Conta conta) {
		if (requisicao.getFormato().equals(Formato.CSV))
			return conta.getNome() + "; " + conta.getValor() + "; ";
		else
			return proxima.responde(requisicao, conta);
	}

	@Override
	public void setProxima(Resposta resposta) {
		this.proxima = resposta;
	}
}
