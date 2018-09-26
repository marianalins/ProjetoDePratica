import java.util.ArrayList;
import java.util.List;

public class ArvoreAVLConta {
    private No raiz;
    private No aux;

    public No getRaiz() {
        return raiz;
    }

    public boolean isEmpty(){
        if(raiz == null){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isfull(){
        return false;
    }

    //PROCURAR CONTA RETORNANDO O NO
    private No procurarConta(String numero){
        if(raiz == null) {
            return null;
        }
        if (aux == null) {
            aux = raiz;
        }
        if(numero.equals(aux.getConta().getNumero())){
            return aux;
        } else if (numero.compareTo(aux.getConta().getNumero())< 0){
            if(aux.getEsquerda() == null){
                return null;
            } else {
                aux = aux.getEsquerda();
                return procurarConta(numero);
            }
        } else {
            if(aux.getDireita() == null){
                return null;
            } else {
                aux = aux.getDireita();
                return procurarConta(numero);
            }
        }
    }

    //PROCURAR CONTA RETORNANDO A CONTA
    public Conta procurar(String numero){
        if(raiz == null) {
            return null;
        }
        if (aux == null) {
            aux = raiz;
        }
        if(numero.equals(aux.getConta().getNumero())){
            return aux.getConta();
        } else if (numero.compareTo(aux.getConta().getNumero())< 0){
            if(aux.getEsquerda() == null){
                return null;
            } else {
                aux = aux.getEsquerda();
                return procurar(numero);
            }
        } else {
            if(aux.getDireita() == null){
                return null;
            } else {
                aux = aux.getDireita();
                return procurar(numero);
            }
        }
    }
    //PROCURAR CPF E RETORNA CONTA
    public Conta procurarCpf(String cpf){
        if(raiz == null) {
            return null;
        }
        if (aux == null) {
            aux = raiz;
        }
        if(cpf.equals(aux.getConta().getCpf())){
            return aux.getConta();
        } else if (cpf.compareTo(aux.getConta().getCpf())< 0){
            if(aux.getEsquerda() == null){
                return null;
            } else {
                aux = aux.getEsquerda();
                return procurarCpf(cpf);
            }
        } else {
            if(aux.getDireita() == null){
                return null;
            } else {
                aux = aux.getDireita();
                return procurarCpf(cpf);
            }
        }
    }

    public void cadastroContaPt1 (String numero , ArvoreAVLCliente clientes) {
        Conta conta = new Conta(numero);        //CONTA CRIADA
        No novoNo = new No(conta);
        Banco banco = new Banco();
        aux = raiz;
        if(isEmpty()) {
            banco.cadastrarInfoConta(conta,clientes);
            raiz = novoNo;
        } else {
            No c = procurarConta(numero);
            if(c != null) {
                System.out.println("Número de Conta Já Exitente.");
            }
            banco.cadastrarInfoConta(conta,clientes);
            cadastroContaPt2(numero,conta,aux);
        }
    }

    public void cadastroContaPt2 (String numero , Conta conta ,No aux) {
        if (numero.compareTo(aux.getConta().getNumero()) < 0) {
            if (aux.getEsquerda() == null) {
                aux.setEsquerda(new No(conta));
            } else {
                aux = aux.getEsquerda();
                cadastroContaPt2(numero, conta , aux);
            }
        } else {
            if (aux.getDireita() == null) {
                aux.setDireita(new No(conta));
            } else {
                aux = aux.getDireita();
                cadastroContaPt2(numero, conta , aux);
            }
        }
    }

    public void consultarSaldo(String numero) {
        Conta retorno = procurar(numero);
        if(retorno != null) {
            retorno.consultarSaldo();
        } else {
            System.out.println("Este Número de Conta Não Existe.");
        }

    }

    public void fazerDeposito(String numero) {
            Conta retorno = procurar(numero);
            if(retorno != null) {
                retorno.fazerDeposito();
            } else {
                System.out.println("Este Número de Conta Não Existe.");
            }
    }


    public void fazerSaque(String numero) {
        Conta retorno = procurar(numero);
        if(retorno != null) {
            retorno.fazerSaque();
        } else {
            System.out.println("Este Número de Conta Não Existe.");
        }
    }

    public List<Conta> getContas() {
        List<Conta> r = new ArrayList<>();
        No no = raiz;
        if(raiz == null) {
            return null;
        }
        emOrdem(no,r);
        return r;
    }

    private void emOrdem(No no , List<Conta> r) {
        if(no != null) {
            emOrdem(no.getEsquerda(),r);
            r.add(no.getConta());
            emOrdem(no.getDireita(),r);
        }

    }





}
