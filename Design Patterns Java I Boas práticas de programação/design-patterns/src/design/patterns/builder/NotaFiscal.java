package design.patterns.builder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotaFiscal {

	private String razaoSocial;
	private String cnpj;
	private double valorBruto;
	private double impostos;
	private Calendar dataEmissao;
	private String observacao;

	private List<ItemDaNota> itens = new ArrayList<>();

	public NotaFiscal(String razaoSocial, String cnpj, double valorBruto, double impostos, Calendar dataEmissao,
			String observacao, List<ItemDaNota> itens) {
		super();
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.valorBruto = valorBruto;
		this.impostos = impostos;
		this.dataEmissao = dataEmissao;
		this.observacao = observacao;
		this.itens = itens;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public double getValorBruto() {
		return valorBruto;
	}

	public double getImpostos() {
		return impostos;
	}

	public Calendar getDataEmissao() {
		return dataEmissao;
	}

	public String getObservacao() {
		return observacao;
	}

	public List<ItemDaNota> getItens() {
		return itens;
	}

	@Override
	public String toString() {
		return razaoSocial + "\n" + cnpj + "\n"
				+ observacao + "\n" + dataEmissao
				+ "\n" + valorBruto + "\n" + impostos
				+ "\n" + itens;
	}
}
