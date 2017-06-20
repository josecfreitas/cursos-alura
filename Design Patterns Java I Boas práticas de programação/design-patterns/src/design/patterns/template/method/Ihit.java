package design.patterns.template.method;

public class Ihit extends TemplateDeImpostoCondicional {

	@Override
	protected double minimaTaxa(Orcamento orcamento) {
		return orcamento.getValor() * (0.01 * orcamento.getItens().size());
	}

	@Override
	protected double maximaTaxa(Orcamento orcamento) {
		return orcamento.getValor() * 0.13 + 100;
	}

	@Override
	protected boolean deveUsarMaximaTaxa(Orcamento orcamento) {
		return temItemComMesmoNome(orcamento);
	}

	private boolean temItemComMesmoNome(Orcamento orcamento) {
		for (Item i : orcamento.getItens()) {
			for (Item j : orcamento.getItens()) {
				if(!i.equals(j) && i.getNome().equals(j.getNome()))
					return true;
			}
		}
		
		return false;
	}

}
