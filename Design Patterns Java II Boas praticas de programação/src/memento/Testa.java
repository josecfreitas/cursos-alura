package memento;

import java.util.Calendar;

public class Testa {

	public static void main(String[] args) {
		Contrato contrato = new Contrato(Calendar.getInstance(), "", TipoContrato.NOVO);
		
		System.out.println(contrato.getTipo());
		contrato.avanca();
		contrato.avanca();
		System.out.println(contrato.getTipo());
		
		System.out.println(contrato.pega(0).getContrato().getTipo());
	}
}
