import java.util.Scanner;

public class Conta {
    private String numero;
    private int tipo;
    private double saldo;
    private String cpf;
    private double credito;
    private Cliente cliente;

    public Conta(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    //===================PROCEDIMENTOS DA CONTA=====================================

    public void consultarSaldo() {
            System.out.println();
            System.out.println();
            System.out.println("Saldo da Conta de Número " + numero + " : R$ " + saldo);
    }

    public void fazerDeposito() {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o valor do depósito");
        System.out.println();
        System.out.print("Valor do depósito: R$ ");
        double dep = in.nextDouble();
        if(tipo == 2 && credito < 2000) {   //COMPLETAR O  CREDITO ANTES DE FAZER O DEPÓSITO
            if(dep <= 2000-credito) {       // SE  O DEPOSITO É MENOR OU IGUAL AO QUE  FALTA PARA COMPLETAR O CREDITO
                credito = credito + dep;
                dep = 0;
            } else {
                dep = dep - (2000-credito);
                credito = credito + (2000-credito);
            }
        }
        saldo = saldo + dep;
        System.out.println();
        System.out.println("Depósito Realizado!");
    }

    public void fazerSaque() {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o valor do saque:");
        System.out.print("Valor do Saque: R$ ");
        double saque = in.nextDouble();
        if(saldo >= saque) {
            saldo = saldo-saque;
            System.out.println("Saque realizado!");
        } else {
            if(tipo == 2 && credito >= saque) {
                credito= credito - saque;
                System.out.println("Saque realizado via credito!");
            } else {
                System.out.println("Não é possível realizar o saque de R$ " +saque);
                System.out.println("Saldo Atual R$ "+saldo);
            }
        }
    }


}
