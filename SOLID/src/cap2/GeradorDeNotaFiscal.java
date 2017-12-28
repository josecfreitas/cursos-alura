package cap2;

public class GeradorDeNotaFiscal {

	private final AcaoAposGerarNf email;
    private final AcaoAposGerarNf dao;

    public GeradorDeNotaFiscal(AcaoAposGerarNf email, AcaoAposGerarNf dao) {
        this.email = email;
        this.dao = dao;
    }

    public NotaFiscal gera(Fatura fatura) {

        double valor = fatura.getValorMensal();

        NotaFiscal nf = new NotaFiscal(valor, impostoSimplesSobreO(valor));

        email.executa(nf);
        dao.executa(nf);

        return nf;
    }

    private double impostoSimplesSobreO(double valor) {
        return valor * 0.06;
    }
}
