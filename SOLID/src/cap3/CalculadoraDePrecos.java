package cap3;

public class CalculadoraDePrecos {

	private TabelaDePreco tabelaDePreco;
	private Frete frete;

	public CalculadoraDePrecos(TabelaDePreco tabelaDePreco, Frete frete) {
		this.tabelaDePreco = tabelaDePreco;
		this.frete = frete;
	}

	public double calcula(Compra produto) {
		double desconto = tabelaDePreco.descontoPara(produto.getValor());
		double valorFrete = frete.para(produto.getCidade());

		return produto.getValor() * (1 - desconto) + valorFrete;
	}
}
