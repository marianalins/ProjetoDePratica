public class NoCliente {
    private Cliente cliente;
    private NoCliente esquerda;
    private NoCliente direita;
    private int fatBal;

    public NoCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getFatBal() {
        return fatBal;
    }

    public void setFatBal(int fatBal) {
        this.fatBal = fatBal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public NoCliente getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoCliente esquerda) {
        this.esquerda = esquerda;
    }

    public NoCliente getDireita() {
        return direita;
    }

    public void setDireita(NoCliente direita) {
        this.direita = direita;
    }
}
