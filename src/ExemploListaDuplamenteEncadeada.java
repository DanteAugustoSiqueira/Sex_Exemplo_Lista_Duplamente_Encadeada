
import java.util.Scanner;

public class ExemploListaDuplamenteEncadeada {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ListaDuplaEncadeada lista = new ListaDuplaEncadeada();
        String elemento = null;
        String opcao = null;
        int posicao = 0;

        do {
            System.out.println("\nEscolha a opção:\n");
            System.out.println("1 -> Adicionar elemento ");
            System.out.println("1.1 -> Adicionar elemento na posição específica ");
            System.out.println("2 -> Excluir elemento na posição específica ");
            System.out.println("3 -> Excluir elemento ");
            System.out.println("4 -> Exibir o elemento Anteior (Antecessor) ");
            System.out.println("5 -> Consultar a posição de um elemento ");
            System.out.println("6 -> Consultar um elemento de uma posição ");
            System.out.println("7 -> Consultar o tamanho da Lista ");
            System.out.println("8 -> Exibir o primeiro elemento da Lista ");
            System.out.println("9 -> Exibir o último elemento da Lista ");
            System.out.println("10 -> Exibir o maior elemento da Lista ");
            System.out.println("0 -> Exibir a Lista Completa ");
            System.out.println("s -> Sair da Aplicação ");

            opcao = entrada.next();

            if (opcao.equals("1")) {
                System.out.println("\nInforme o valor do elemento");
                elemento = entrada.next();
                try {
                    lista.adicionar(elemento);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("1.1")) {
                System.out.println("\nInforme o valor do elemento");
                elemento = entrada.next();
                System.out.println("\nInforme a posição do elemento");
                posicao = entrada.nextInt();
                try {
                    lista.adicionar(elemento, posicao);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("2")) {
                System.out.println("\nInforme a posição do elemento");
                posicao = entrada.nextInt();
                try {
                    lista.removeIndex(posicao);
                    System.out.println("Elemento removido com sucesso!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("3")) {
                System.out.println("\nInforme o valor do elemento");
                elemento = entrada.next();
                try {
                    lista.removeElemento(elemento);
                    System.out.println("Elemento removido com sucesso!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("4")) {
                System.out.println("\nInforme o valor do elemento");
                elemento = entrada.next();
                try {
                    String ant = lista.antecessor(elemento);
                    System.out.println("Antecessor: " + ant);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("5")) {
                System.out.println("\nInforme o valor do elemento");
                elemento = entrada.next();
                try {
                    int pos = lista.posicao(elemento);
                    System.out.println("Posição do elemento: " + pos);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("6")) {
                System.out.println("\nInforme a posição do elemento");
                posicao = entrada.nextInt();
                try {
                    String val = lista.BuscaPosicao(posicao);
                    System.out.println("Elemento na posição " + posicao + ": " + val);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("7")) {
                try {
                    int tam = lista.tamanhoLista();
                    System.out.println("O tamanho da lista é: " + tam);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("8")) {
                try {
                    String primeiro = lista.primeiroLista();
                    System.out.println("Primeiro elemento: " + primeiro);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("9")) {
                try {
                    String ultimo = lista.ultimoLista();
                    System.out.println("Último elemento: " + ultimo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("10")) {
                try {
                    String maiorVal = lista.maior();
                    System.out.println("Maior elemento: " + maiorVal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("0")) {
                try {
                    lista.exibir();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (!opcao.equalsIgnoreCase("s")) {
                System.out.println("Opção inválida!");
            }
        } while (!opcao.equalsIgnoreCase("s"));

        entrada.close();
    }
}
