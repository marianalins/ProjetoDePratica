public class No {
    private String numero;
    private No esquerda;
    private No direita;
    private No pai;
    private int fatBal; // Fator de balanceamento


    public No(String numero) {
        setEsquerda(null);
        setDireita(null);
        setPai(null);
        setFatBal(0);
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public int getFatBal() {
        return fatBal;
    }

    public void setFatBal(int fatBal) {
        this.fatBal = fatBal;
    }
}
