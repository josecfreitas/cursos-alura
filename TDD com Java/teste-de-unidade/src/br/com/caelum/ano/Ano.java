package br.com.caelum.ano;

public class Ano {

	private int ano;

	public Ano(int ano) {
		this.ano = ano;
	}

	public int getAno() {
		return ano;
	}

	public boolean ehBissexto() {
		if (multiploDe400() || multiploDe4NaoCentenario())
			return true;
		
		return false;
	}

	private boolean multiploDe4NaoCentenario() {
		return ano % 4 == 0 && ano % 100 != 0;
	}

	private boolean multiploDe400() {
		return ano % 400 == 0;
	}
}
