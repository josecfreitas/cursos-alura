package cap2;

public class EnviadorDeEmail implements AcaoAposGerarNf {

	public void executa(NotaFiscal nf) {
        System.out.println("envia email da nf " + nf.getId());
    }
}
