public class TipoDeConta {
    private int contaCorrente;
    private int simples = 1;
    private int especial = 2;

    public TipoDeConta(int contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public int getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(int contaCorrente) {
        this.contaCorrente = contaCorrente;
    }
}
