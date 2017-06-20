package design.patterns.chain.of.responsability.exercício;

public class SemResposta implements Resposta {

	@Override
	public String responde(Requisicao requisicao, Conta conta) {
		return "";
	}

	@Override
	public void setProxima(Resposta resposta) {
	}

}
