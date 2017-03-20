package br.com.gbd.testesalura;

/*
    Autor(es): José Carlos de Freitas
    Data: 15/03/2017 às 22:16:29
    Arquivo: ContaCorrente
*/
public class ContaCorrente extends Conta{

    @Override
    public void atualiza(double taxa){
        this.saldo += this.saldo * taxa * 2;
    }
}
