package design.patterns.chain.of.responsability.exercício;

public class RespostaXml implements Resposta {

	private Resposta proxima;

	public RespostaXml(Resposta proxima) {
		super();
		this.proxima = proxima;
	}

	@Override
	public String responde(Requisicao requisicao, Conta conta) {
		if (requisicao.getFormato().equals(Formato.XML))
			return "<conta><titular>" + conta.getNome() + "</titular><saldo>" + conta.getValor() + "</saldo></conta>";
		else
			return proxima.responde(requisicao, conta);
	}

	@Override
	public void setProxima(Resposta resposta) {
		this.proxima = resposta;
	}

}
