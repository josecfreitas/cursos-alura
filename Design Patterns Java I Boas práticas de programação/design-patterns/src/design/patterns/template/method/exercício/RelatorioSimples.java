package design.patterns.template.method.exercício;

import java.util.List;

import design.patterns.chain.of.responsability.exercício.Conta;

public class RelatorioSimples extends TemplateDeRelatorio {

	@Override
	public String cabecalho() {
		return "Banco do Brasil\t(12)1231-2131";
	}

	@Override
	public String rodape() {
		return "\nBanco do Brasil\t(12)1231-2131";
	}

	@Override
	public String corpo(List<Conta> contas) {
		String retorno = "\n";
		for (Conta conta : contas) {
			retorno += "\n" + conta.getNome() + " : " + conta.getValor();
		}
		return retorno+ "\n";
	}

}
