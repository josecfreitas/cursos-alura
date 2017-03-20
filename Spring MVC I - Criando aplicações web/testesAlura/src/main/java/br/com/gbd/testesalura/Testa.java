package br.com.gbd.testesalura;

/*
    Autor(es): José Carlos de Freitas
    Data: 15/03/2017 às 22:10:47
    Arquivo: Testa
*/
public class Testa {

    public static void main(String[] args){
        Conta c = new Conta();
        ContaCorrente cc = new ContaCorrente();
        ContaPoupanca cp = new ContaPoupanca();

        c.deposita(1000); 
        cc.deposita(1000); 
        cp.deposita(1000);

        AtualizadorDeContas adc = new AtualizadorDeContas(0.01);

        adc.roda(c);
        adc.roda(cc);
        adc.roda(cp);

        System.out.println("Saldo Total: " + adc.getSaldoTotal());
    }
}
