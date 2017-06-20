package design.patterns.template.method.exercício;

import java.util.List;

import design.patterns.chain.of.responsability.exercício.Conta;

public abstract class TemplateDeRelatorio {

	public String relatorio(List<Conta> contas){
		return cabecalho() + corpo(contas) + rodape();
	}
	public abstract String cabecalho();
	public abstract String rodape();
	public abstract String corpo(List<Conta> contas);
}
