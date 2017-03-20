package br.com.gbd.testesalura;

/*
    Autor(es): José Carlos de Freitas
    Data: 15/03/2017 às 22:11:15
    Arquivo: Conta
*/
public class Conta {

    protected double saldo;
    
    public double getSaldo(){
        return this.saldo;
    }
    
    public void deposita(double valor){
        this.saldo += valor;
    }
    
    public void saca(double valor){
        this.saldo -= valor;
    }
    
    public void atualiza(double taxa){
        this.saldo += this.saldo * taxa;
    }
}
