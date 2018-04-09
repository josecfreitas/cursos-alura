package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;

	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}

	public void propoe(Lance lance) {
		verificaSeLanceEhValido(lance);
		
		if (lances.isEmpty() || podeProporLance(lance.getUsuario()))
			lances.add(lance);
	}

	private void verificaSeLanceEhValido(Lance lance) {
		if(lance.getValor() <= 0) throw new IllegalArgumentException();
	}

	private boolean podeProporLance(Usuario usuario) {
		return (!ultimoLance().getUsuario().equals(usuario) && numeroDeLancesDo(usuario) < 5);
	}

	private int numeroDeLancesDo(Usuario usuario) {
		int total = 0;

		for (Lance lance : lances) {
			if (lance.getUsuario().equals(usuario))
				total++;
		}

		return total;
	}

	private Lance ultimoLance() {
		return lances.get(lances.size() - 1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	public void dobrarLance(Usuario usuario) {
		Lance lance = ultimoLanceDo(usuario);
		if (lance != null) {
			propoe(new Lance(usuario, lance.getValor() * 2));
		}
	}

	private Lance ultimoLanceDo(Usuario usuario) {
		Lance ultimoLance = null;
		for (Lance lance : lances) {
			if (lance.getUsuario().equals(usuario))
				ultimoLance = lance;
		}

		return ultimoLance;
	}

}
