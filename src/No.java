public class No {
    private Conta conta;
    private No esquerda;
    private No direita;
    private int fatBall;

    public int getFatBall() {
        return fatBall;
    }

    public void setFatBall(int fatBall) {
        this.fatBall = fatBall;
    }

    public No(Conta conta) {
        this.conta = conta;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

}
