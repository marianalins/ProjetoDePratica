public class ArvoreAVL {
    private No raiz;

    public void inserir (String numero) {
        No no = new No(numero);
        inserirAVL(this.raiz , no);
    }

    public void inserirAVL (No aComparar , No aInserir) {
        if(aComparar == null) {
            this.raiz = aInserir;
        } else {
            if (aInserir.getNumero().compareTo(aComparar.getNumero()) < 0) {
                if (aComparar.getEsquerda() == null) {
                    aComparar.setEsquerda(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);

                } else {
                    inserirAVL(aComparar.getEsquerda(), aInserir);
                }
            } else if (aInserir.getNumero().compareTo(aComparar.getNumero()) > 0) {
                if (aComparar.getDireita() == null) {
                    aComparar.setDireita(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);

                } else {
                    inserirAVL(aComparar.getDireita(), aInserir);
                }

            } else {
                // O nó já existe
            }
        }
    }

    public int altura(No atual) {
        if(atual == null) {
            return -1;
        }

        if(atual.getDireita() == null && atual.getEsquerda() == null) {
            return 0;
        } else if(atual.getEsquerda() == null) {
            return 1 + altura(atual.getDireita());
        } else if(atual.getDireita() == null) {
            return 1 + altura(atual.getEsquerda());
        } else {
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
        }


    }

    public void verificarBalanceamento(No atual) {

    }
}
