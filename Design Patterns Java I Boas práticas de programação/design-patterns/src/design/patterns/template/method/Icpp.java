package design.patterns.template.method;

public class Icpp extends TemplateDeImpostoCondicional {

	@Override
	protected double minimaTaxa(Orcamento orcamento) {
		return orcamento.getValor() * 0.05;
	}

	@Override
	protected double maximaTaxa(Orcamento orcamento) {
		return orcamento.getValor() * 0.07;
	}

	@Override
	protected boolean deveUsarMaximaTaxa(Orcamento orcamento) {
		return orcamento.getValor() >= 500;
	}

}
