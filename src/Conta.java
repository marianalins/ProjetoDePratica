public class Conta {
    private String numero;
    private TipoDeConta tipo;
    private double saldo;
    private String cpf;

    public Conta(String numero, TipoDeConta tipo, double saldo, String cpf) {
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = saldo;
        this.cpf = cpf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoDeConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeConta tipo) {
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
}
