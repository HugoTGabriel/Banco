package aula;

public class ContaDebEspecial extends ContaEspecial {

    public ContaDebEspecial() {}

    public ContaDebEspecial(String n, double s, double l) {
        numero = n;
        saldo = s;
        limite = l;
    }

    void debitar(double valor) {
        if ((limite + saldo) >= valor) {
            saldo -= valor;
        }
    }
}