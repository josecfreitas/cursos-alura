package design.patterns.template.method;

public class Ikcv extends TemplateDeImpostoCondicional {

	@Override
	protected double minimaTaxa(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}

	@Override
	protected double maximaTaxa(Orcamento orcamento) {
		return orcamento.getValor() * 0.1;
	}

	@Override
	protected boolean deveUsarMaximaTaxa(Orcamento orcamento) {
		return orcamento.getValor() >= 500 && temItemValorSuperior100Reais(orcamento);
	}

	private boolean temItemValorSuperior100Reais(Orcamento orcamento) {
		for (Item item : orcamento.getItens()) {
			if (item.getValor() >= 100)
				return true;
		}
		return false;
	}

}
