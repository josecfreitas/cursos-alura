package design.patterns.chain.of.responsability;

public class DescontoPorMaisDeCincoItens implements Desconto {

	private Desconto proximo;

	@Override
	public double calcula(Orcamento orcamento) {
		if (orcamento.getItens().size() >= 5)
			return orcamento.getValor() * 0.1;
		else
			return proximo.calcula(orcamento);
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}
}
