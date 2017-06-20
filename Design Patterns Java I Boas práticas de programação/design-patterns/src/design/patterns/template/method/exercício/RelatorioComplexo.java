package design.patterns.template.method.exercício;

import java.util.Date;
import java.util.List;

import design.patterns.chain.of.responsability.exercício.Conta;

public class RelatorioComplexo extends TemplateDeRelatorio {

	@Override
	public String cabecalho() {
		return "Banco do Brasil\tRua tal, 123. Brasil.\n(12)1231-2131";
	}

	@Override
	public String rodape() {
		return "\nemail@bancodobrasil.com.br\t" + new Date();
	}

	@Override
	public String corpo(List<Conta> contas) {
		String retorno = "\n";
		for (Conta conta : contas) {
			retorno += "\n" + conta.getNome() + " : " + conta.getValor();
		}
		return retorno + "\n";
	}

}
