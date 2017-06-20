package design.patterns.chain.of.responsability;

public class DescontoPorLapisOuCaneta implements Desconto {

	private Desconto proximo;

	@Override
	public double calcula(Orcamento orcamento) {
		if(existe("Lapis", orcamento) || existe("Caneta", orcamento))
			return orcamento.getValor() * 0.05;
		else
			return proximo.calcula(orcamento);
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

	private boolean existe(String nomeDoItem, Orcamento orcamento) {
        for (Item item : orcamento.getItens()) {
            if(item.getNome().equals(nomeDoItem)) return true;
        }
        return false;
    }
}
