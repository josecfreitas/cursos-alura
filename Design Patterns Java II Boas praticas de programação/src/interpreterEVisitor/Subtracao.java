package interpreterEVisitor;

public class Subtracao implements Expressao {

	private Expressao esquerda;
	private Expressao direita;

	public Subtracao(Expressao esquerda, Expressao direita) {
		this.esquerda = esquerda;
		this.direita = direita;
	}

	public Expressao getEsquerda() {
		return esquerda;
	}

	public Expressao getDireita() {
		return direita;
	}

	@Override
	public int avalia() {
		return esquerda.avalia() - direita.avalia();
	}

	@Override
	public void aceita(Visitor impressora) {
		impressora.visitaSubtracao(this);
	}
}
