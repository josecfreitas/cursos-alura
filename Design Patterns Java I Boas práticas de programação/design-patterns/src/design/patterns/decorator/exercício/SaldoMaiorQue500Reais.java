package design.patterns.decorator.exercício;

import java.util.List;
import java.util.stream.Collectors;

import design.patterns.chain.of.responsability.exercício.Conta;

public class SaldoMaiorQue500Reais extends Filtro {

	public SaldoMaiorQue500Reais() {
		super();
	}

	public SaldoMaiorQue500Reais(Filtro proxFiltro) {
		super(proxFiltro);
	}

	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> retorno = contas.stream().filter(c -> c.getValor() > 500).collect(Collectors.toList());
		retorno.addAll(filtraProx(contas));
		return retorno;
	}

}
