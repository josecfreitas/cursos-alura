package interpreterEVisitor;

public class Testa {

	public static void main(String[] args) {

		Expressao conta = new Soma(new Numero(10), new Numero(20));
		conta = new Subtracao(conta, conta);
		
		System.out.println(conta.avalia());

		Visitor impressora = new ImpressoraVisitor();
		Visitor preImpressora = new PreImpressoraVisitor();
		conta.aceita(impressora);
		System.out.println();
		conta.aceita(preImpressora);
	}
}
