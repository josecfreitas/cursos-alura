package design.patterns.chain.of.responsability.exercício;

public interface Resposta {

	public String responde (Requisicao requisicao, Conta conta);
	public void setProxima(Resposta resposta);
}
