package design.patterns.template.method;

public abstract class TemplateDeImpostoCondicional implements Imposto {

	@Override
	public double calcula(Orcamento orcamento) {
		if(deveUsarMaximaTaxa(orcamento)){
			return maximaTaxa(orcamento);
		} else {
			return minimaTaxa(orcamento);
		}
	}

	protected abstract double minimaTaxa(Orcamento orcamento);

	protected abstract double maximaTaxa(Orcamento orcamento);
	
	protected abstract boolean deveUsarMaximaTaxa(Orcamento orcamento);
	
}
