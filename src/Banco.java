import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Banco {
//=================PEDIR NÚMERO DA CONTA==================================================
    public static String pedirNumeroConta() {
        Scanner str = new Scanner(System.in);
        String numero;
        System.out.print("Informe o número da conta: ");
        numero = str.nextLine();
        return numero;
    }
//=======================CADASTRO DE CONTA=============================================
    public static void cadastrarConta(ArvoreAVLConta arvore , String numero, ArvoreAVLCliente clientes) {
        //SE O NÚMERO DA CONTA JÁ EXISTE, NÃO CADASTRA.
        arvore.cadastroContaPt1(numero , clientes);
    }
//================EXIBIR==================================================================
    public static void exibir(ArvoreAVLConta contas) {
        List<Conta> c = contas.getContas();
        if(c == null) {
            System.out.println("Nenhuma Conta Cadastrada no Banco");
            return;
        }

        System.out.println("======================= CONTAS BANCO DINHEIRO CERTO =======================");
        for(Conta conta : c) {
            System.out.print("Número da Conta: " + conta.getNumero());
            System.out.println();
            System.out.print("Nome do Titular: " + conta.getCliente().getNome());
            System.out.println();
            System.out.print("Telefone: " +conta.getCliente().getTelefone());
            System.out.println();
            System.out.println();
        }
    }

    public static void exibirContasCliente(ArvoreAVLConta contas , String cpf, ArvoreAVLCliente clientes) {
        Conta r = contas.procurar(cpf);

        if(r != null) {
            List<Conta> c = contas.getContas();
            System.out.println();
            System.out.println("========== CONTAS DO CLIENTE ==========");
            System.out.println();
            System.out.println("CPF: " + r.getCpf());
            System.out.println();
            for(Conta conta: c) {
                if(conta.getCpf().equals(cpf)) {
                    System.out.println("Número da Conta: " +conta.getNumero());
                    if(conta.getTipo() == 1) {
                        System.out.println("Tipo de Conta: Conta Simples(1)");
                    } else {
                        System.out.println("Tipo de Conta: Conta Especial(2)");
                    }
                }
                System.out.println();
            }
        } else if (clientes.procurar(cpf) != null && contas.procurarCpf(cpf) == null){
            System.out.println("Cliente Não Possui Conta.");
        } else {
            System.out.println("CPF Não Cadastrado.");
        }
    }
//==================CADASTROS DE INFORMAÇÕES=================================================
    public static void cadastrarInfoCliente(Cliente cliente) {
        Scanner str = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = str.nextLine();
        cliente.setNome(nome);
        System.out.println("E-mail: ");
        String email = str.nextLine();
        cliente.setEmail(email);
        System.out.println("Telefone: ");
        String telefone = str.nextLine();
        cliente.setTelefone(telefone);
    }


    public static void cadastrarInfoConta(Conta conta , ArvoreAVLCliente c) {  //RECEBE A CONTA E A ÁRVORE CLIENTE
        Scanner in = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        Cliente cliente;
        int tipo;

        do{
            System.out.println("1 - Para Tipo de Conta Corrente Simples");
            System.out.println("2 - Pra Tipo de Conta Corrente Especial");

            System.out.print("Tipo de Conta: ");
            tipo = in.nextInt();
            conta.setTipo(tipo);
        } while(tipo != 1 && tipo != 2);

        if(conta.getTipo() == 2){
            conta.setCredito(2000);
        }

        System.out.print("Saldo: ");
        double saldo = in.nextDouble();
        conta.setSaldo(saldo);
        System.out.print("CPF: ");
        String cpf = str.nextLine();
        if(c.procurar(cpf) != null) {
            conta.setCliente(c.procurar(cpf));
            return;
        }
        c.cadastrarClientePt1(cpf);     //SE O CLIENTE NÃO EXISTIR , CRIA
        conta.setCliente(c.procurar(cpf));
    }
//===================================MENU=========================================================
    public static void menu() {
        System.out.println("=======================   Banco Dinheiro Certo   =============================");
        System.out.println();
        System.out.println();
        System.out.println("Digite o número correspondente a opção desejada:");
        System.out.println("1 - Cadastrar Conta");
        System.out.println("2 - Saldo da Conta");
        System.out.println("3 - Fazer Depósito");
        System.out.println("4 - Realizar Saque");
        System.out.println("5 - Exibir Contas do Banco");
        System.out.println("6 - Cadastrar Cliente");
        System.out.println("7 - Exibir Nº de Contas de Um Cliente");
        System.out.print("Digite Aqui: ");
    }
//=========================MAIN===============================================================
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        int op;     //OPÇÃO MENU
        String cpf;
        String numero;      //NUMERO DA CONTA
        ArvoreAVLConta arvore = new ArvoreAVLConta();
        ArvoreAVLCliente arvoreCliente = new ArvoreAVLCliente();


        do {
            menu();
            op = in.nextInt();
            switch (op) {
                case 1:
                    cadastrarConta(arvore,pedirNumeroConta(),arvoreCliente);
                    break;
                case 2:
                    numero = pedirNumeroConta();
                    arvore.consultarSaldo(numero);
                    break;
                case 3:
                    numero = pedirNumeroConta();
                    arvore.fazerDeposito(numero);
                    break;
                case 4:
                    numero = pedirNumeroConta();
                    arvore.fazerSaque(numero);
                    break;
                case 5:
                    exibir(arvore);
                    break;
                case 6:
                    System.out.print("Informe o CPF: ");
                     cpf = str.nextLine();
                    arvoreCliente.cadastrarClientePt1(cpf);
                    break;
                case 7:
                    System.out.print("Informe o CPF: ");
                    cpf = str.nextLine();
                    exibirContasCliente(arvore,cpf,arvoreCliente);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while(op != 8);

    }

}
