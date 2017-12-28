package cap2;

public class Testa {

	public static void main(String[] args) {
		GeradorDeNotaFiscal geradorDeNotaFiscal = new GeradorDeNotaFiscal(new EnviadorDeEmail(), new NotaFiscalDao());
		
		Fatura fatura = new Fatura(100, "José");
		NotaFiscal notaFiscal = geradorDeNotaFiscal.gera(fatura);
		notaFiscal = geradorDeNotaFiscal.gera(fatura);
	}
}
