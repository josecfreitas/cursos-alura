package design.patterns.builder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import design.patterns.observer.AposConstrucaoNotaFiscal;

public class NotaFiscalBuilder {

	private String razaoSocial;
	private String cnpj;
	private double valorBruto;
	private double impostos;
	private Calendar dataEmissao;
	private String observacao;
	
	List<AposConstrucaoNotaFiscal> rotinas = new ArrayList<>();
	
	private List<ItemDaNota> itens = new ArrayList<>();
	
	public NotaFiscalBuilder(List<AposConstrucaoNotaFiscal> rotinas) {
		 dataEmissao = Calendar.getInstance();
		 this.rotinas = rotinas;
	}
	
	public NotaFiscalBuilder add(AposConstrucaoNotaFiscal rotina){
		rotinas.add(rotina);
		
		return this;
	}

	public NotaFiscalBuilder paraEmpresa(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}

	public NotaFiscalBuilder comCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	public NotaFiscalBuilder naData(Calendar dataEmissao) {
		this.dataEmissao = dataEmissao;
		return this;
	}

	public NotaFiscalBuilder comObservacao(String observacao) {
		this.observacao = observacao;
		return this;
	}

	public NotaFiscalBuilder com(ItemDaNota item) {
		itens.add(item);
		valorBruto += item.getValor();
		impostos += item.getValor() * 0.05;
		return this;
	}

	public NotaFiscal construir(){
		NotaFiscal notaFiscal = new NotaFiscal(razaoSocial, cnpj, valorBruto, impostos, dataEmissao, observacao, itens);
		
		rotinas.forEach(r -> r.executar(notaFiscal));
		
		return notaFiscal;
	}
}
