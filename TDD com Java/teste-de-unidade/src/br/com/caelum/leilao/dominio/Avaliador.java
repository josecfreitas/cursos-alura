package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avaliador {

	private double maiorValor = Double.NEGATIVE_INFINITY;
	private double menorValor = Double.POSITIVE_INFINITY;
	private double valorMedio;
    private List<Lance> maiores;
	
	public void avalia(Leilao leilao){
		if(leilao.getLances().size() == 0) throw new RuntimeException();
		
		for (Lance lance : leilao.getLances()) {
			valorMedio += lance.getValor();
			
			if(lance.getValor() >= maiorValor) maiorValor = lance.getValor();
			if(lance.getValor() <= menorValor) menorValor = lance.getValor();
		}
		
		valorMedio /= leilao.getLances().size();

        pegaOsMaioresNo(leilao);
	}

    private void pegaOsMaioresNo(Leilao leilao) {
        maiores = new ArrayList<Lance>(leilao.getLances());
        Collections.sort(maiores, new Comparator<Lance>() {
            public int compare(Lance o1, Lance o2) {
                if(o1.getValor() < o2.getValor()) return 1;
                if(o1.getValor() > o2.getValor()) return -1;
                return 0;
            }
        });
        maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
    }

	public double getMaiorLance() {
		return maiorValor;
	}

	public double getMenorLance() {
		return menorValor;
	}

	public double getValorMedio() {
		return valorMedio;
	}
	
    public List<Lance> getTresMaiores() {
        return Collections.unmodifiableList(this.maiores);
    }
}
