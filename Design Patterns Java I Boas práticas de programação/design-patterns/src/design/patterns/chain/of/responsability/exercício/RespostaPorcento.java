package design.patterns.chain.of.responsability.exercício;

public class RespostaPorcento implements Resposta {

	private Resposta proxima;

	public RespostaPorcento(Resposta proxima) {
		super();
		this.proxima = proxima;
	}

	@Override
	public String responde(Requisicao requisicao, Conta conta) {
		if (requisicao.getFormato().equals(Formato.PORCENTO))
			return conta.getNome() + "% " + conta.getValor() + "% ";
		else
			return proxima.responde(requisicao, conta);
	}

	@Override
	public void setProxima(Resposta resposta) {
		this.proxima = resposta;
	}

}
