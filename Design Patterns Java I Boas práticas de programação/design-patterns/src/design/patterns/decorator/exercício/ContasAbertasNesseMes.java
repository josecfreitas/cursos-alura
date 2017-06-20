package design.patterns.decorator.exercício;

import java.util.List;
import java.util.stream.Collectors;

import design.patterns.chain.of.responsability.exercício.Conta;

public class ContasAbertasNesseMes extends Filtro {

	public ContasAbertasNesseMes() {
		super();
	}

	public ContasAbertasNesseMes(Filtro proxFiltro) {
		super(proxFiltro);
	}

	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> retorno = contas.stream().filter(c -> c.getNome().equals("Jose Carlos"))
				.collect(Collectors.toList());
		retorno.addAll(filtraProx(contas));
		return retorno;
	}
}
