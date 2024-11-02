import java.util.*;

abstract public class Conta {
    protected String numero; 
    protected double saldo;

    protected String getNumero() {
        return numero;
    }

    protected void setNumero(String value) {
        numero = value;
    }

    protected double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double value) {
        saldo = value;
    }

    abstract void creditar(double valor);
    abstract void debitar(double valor);
}

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

abstract public class ContaEspecial extends Conta {
    protected double limite;

    protected void setLimite(double value) {
        limite = value;
    }

    protected double getLimite() {
        return limite;
    }

    public void creditar(double valor) {
        saldo += valor; 
    }
}

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

public class Banco {
    public static void main(String[] args) {
        
        Conta c1 = new ContaNormal();
        c1.setNumero("1654-3");
        c1.setSaldo(500);

        ContaDebEspecial c2 = new ContaDebEspecial("4067-6", 2500, 5050);

        
        System.out.println("A conta número " + c1.getNumero() + " possui saldo " + c1.getSaldo());
        c1.creditar(1000);
        System.out.println("Após o crédito de R$ 1000,00, a conta número " + c1.getNumero() + " passou a ter saldo " + c1.getSaldo());
        c1.debitar(100);
        System.out.println("Após o débito de R$ 100,00, a conta número " + c1.getNumero() + " passou a ter saldo " + c1.getSaldo());

        
        System.out.println("\nA conta número " + c2.getNumero() + " possui saldo " + c2.getSaldo());
        c2.debitar(500);
        System.out.println("Após débito de R$ 500, a conta número " + c2.getNumero() + " possui saldo " + c2.getSaldo());
        System.out.println("E Limite de " + c2.getLimite());
        c2.setLimite(10000);
        System.out.println("Novo limite: " + c2.getLimite());
    }
}
