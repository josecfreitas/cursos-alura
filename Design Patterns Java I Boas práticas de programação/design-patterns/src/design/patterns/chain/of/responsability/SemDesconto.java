package design.patterns.chain.of.responsability;

public class SemDesconto implements Desconto {

	@Override
	public double calcula(Orcamento orcamento) {
		return 0;
	}

	@Override
	public void setProximo(Desconto proximo) {
	}

}
