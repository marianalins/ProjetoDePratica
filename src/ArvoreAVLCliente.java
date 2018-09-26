import java.util.ArrayList;
import java.util.List;

public class ArvoreAVLCliente {
    private NoCliente raiz;
    private NoCliente aux;

    public NoCliente getRaiz() {
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

    public Cliente procurar(String cpf){
        if(raiz == null) {
            return null;
        }
        if (aux == null) {
            aux = raiz;
        }
        if(cpf.equals(aux.getCliente().getCpf())){
            return aux.getCliente();
        } else if (cpf.compareTo(aux.getCliente().getCpf())< 0){
            if(aux.getEsquerda() == null){
                return null;
            } else {
                aux = aux.getEsquerda();
                return procurar(cpf);
            }
        } else {
            if(aux.getDireita() == null){
                return null;
            } else {
                aux = aux.getDireita();
                return procurar(cpf);
            }
        }
    }


    public NoCliente procurarCliente(String cpf){
        if(raiz == null) {
            return null;
        }
        if (aux == null) {
            aux = raiz;
        }
        if(cpf.equals(aux.getCliente().getCpf())){
            return aux;
        } else if (cpf.compareTo(aux.getCliente().getCpf())< 0){
            if(aux.getEsquerda() == null){
                return null;
            } else {
                aux = aux.getEsquerda();
                return procurarCliente(cpf);
            }
        } else {
            if(aux.getDireita() == null){
                return null;
            } else {
                aux = aux.getDireita();
                return procurarCliente(cpf);
            }
        }
    }

    public void cadastrarClientePt1(String cpf) {
        if(procurar(cpf) != null) {     //SE O CLIENTE JA ESTIVER CADASTRADO
            return;
        }
        Cliente cliente = new Cliente(cpf);        //CLIENTE CRIADO
        NoCliente novoNo = new NoCliente(cliente);
        Banco banco = new Banco();
        aux = raiz;

        if(isEmpty()) {
            banco.cadastrarInfoCliente(cliente);
            raiz = novoNo;
        } else {
            NoCliente c = procurarCliente(cpf);
            if(c != null) {
                System.out.println("Este CPF já existe");
                return;
            }
            banco.cadastrarInfoCliente(cliente);
            cadastroClientePt2(cpf,cliente,aux);
        }
    }

    public void cadastroClientePt2(String cpf , Cliente cliente , NoCliente aux) {
        if (cpf.compareTo(aux.getCliente().getCpf()) < 0) {
            if (aux.getEsquerda() == null) {
                aux.setEsquerda(new NoCliente(cliente));
            } else {
                aux = aux.getEsquerda();
                cadastroClientePt2(cpf, cliente , aux);
            }
        } else {
            if (aux.getDireita() == null) {
                aux.setDireita(new NoCliente(cliente));
            } else {
                aux = aux.getDireita();
                cadastroClientePt2(cpf, cliente , aux);
            }
        }
    }

    public NoCliente maior(NoCliente cliente , NoCliente ant) {
        if (cliente == null) {
            return null;
        }

        if (cliente.getDireita() == null) {
            return cliente;
        }
        ant = cliente;
        cliente = cliente.getDireita();
        return maior(cliente , ant);
    }

    private void copyNode(NoCliente source, NoCliente target) {
        target.setCliente(source.getCliente());
    }


    // funcao utilizada para remover qualquer node que contenha 1 ou menos filhos
    private void removeNode(NoCliente node, NoCliente ant) {
        if(ant.getDireita() == node) {
            ant.setDireita((node.getEsquerda() == null) ? node.getDireita() : node.getEsquerda() );
        } else {
            ant.setEsquerda((node.getDireita() == null) ? node.getEsquerda() : node.getDireita());
        }
    }

    public boolean removerCliente(String cpf) {
        NoCliente remover = raiz;

        if(raiz == null)  { // arvore vazia
            return false;
        }

        // removido ẽ raiz e tem no maximo um filho
        if(cpf == raiz.getCliente().getCpf() && (raiz.getDireita() == null || raiz.getEsquerda() == null)) {
            raiz = (raiz.getDireita() == null) ? raiz.getEsquerda() : raiz.getDireita();
            return true;
        }

        NoCliente ant = null;
        while(remover != null) { // procura o node
            if(cpf.equals(remover.getCliente().getCpf())) {
                break;
            } else if(cpf.compareTo(remover.getCliente().getCpf()) < 0) {
                ant = remover;
                remover = remover.getEsquerda();
            } else {
                ant = remover;
                remover = remover.getDireita();
            }
        }

        if(remover == null) { // node nao existe
            return false;
        }

        if(remover.getDireita() != null && remover.getEsquerda() != null) { // tem dois filhos
            NoCliente antMaior = remover;
            NoCliente maiorNode = maior(remover.getEsquerda(), antMaior);
            copyNode(maiorNode, remover);
            removeNode(maiorNode, antMaior);
        } else { // contem 1 ou menos filhos
            removeNode(remover,ant);
        }
        return true;
    }

}
