package aula;

public class ContaNormal extends Conta {
    public void creditar(double valor) {
        saldo += valor; 
    }

    public void debitar(double valor) { 
        if (saldo >= valor) {
            saldo -= valor; 
        }
    }
}