package design.patterns.strategy.exercício;

public class RealizadorDeInvestimento {

	public void investir(Conta conta, Investidor investidor) {
		conta.depositar(investidor.retorno(conta));
	}
}
