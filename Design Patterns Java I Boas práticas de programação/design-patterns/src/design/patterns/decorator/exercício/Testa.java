package design.patterns.decorator.exercício;

import java.util.ArrayList;
import java.util.List;

import design.patterns.chain.of.responsability.exercício.Conta;

public class Testa {

	public static void main(String[] args) {
		List<Conta> contas = new ArrayList<>();

		contas.add(new Conta("Jose", 400));
		contas.add(new Conta("Jose", 600));
		contas.add(new Conta("Jose Carlos", 200));
		contas.add(new Conta("Jose", 50));

		Filtro filtros = new SaldoMenorQue100Reais(new SaldoMaiorQue500Reais(new ContasAbertasNesseMes()));
		
		System.out.println(filtros.filtra(contas));
	}
}
