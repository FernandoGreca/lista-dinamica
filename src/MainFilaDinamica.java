import java.util.Scanner;

import model.FilaDinamica;
import model.No;

public class MainFilaDinamica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== INICIALIZAÇÃO DA FILA =====");
        System.out.print("Digite o valor do primeiro elemento da fila: ");
        int primeiroElemento = scanner.nextInt();
        FilaDinamica fila = new FilaDinamica(primeiroElemento);
        System.out.println("Fila criada com sucesso! O primeiro elemento é: " + primeiroElemento);

        boolean sair = false;
        while (!sair) {

            exibirMenu();

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a ser inserido: ");
                    int elemento = scanner.nextInt();
                    fila.inserirElemento(elemento);
                    limparTela();
                    System.out.println("Elemento " + elemento + " inserido com sucesso!");
                    break;

                case 2:
                    System.out.print("Quantos elementos deseja inserir? ");
                    int n = scanner.nextInt();
                    Integer[] elementos = new Integer[n];
                    System.out.println("Digite os elementos (um por linha):");
                    for (int i = 0; i < n; i++) {
                        elementos[i] = scanner.nextInt();
                    }
                    fila.inserirSequencia(elementos);
                    limparTela();
                    System.out.println(n + " elementos inseridos com sucesso!");
                    break;

                case 3:
                    System.out.print("Digite o elemento a ser removido: ");
                    int elementoRemover = scanner.nextInt();
                    fila.removerElemento(elementoRemover);
                    limparTela();
                    break;

                case 4:
                    System.out.print("Quantos elementos deseja remover? ");
                    int m = scanner.nextInt();
                    Integer[] elementosRemover = new Integer[m];
                    System.out.println("Digite os elementos a remover (um por linha):");
                    for (int i = 0; i < m; i++) {
                        elementosRemover[i] = scanner.nextInt();
                    }
                    fila.removerSequencia(elementosRemover);
                    limparTela();
                    System.out.println("Operação de remoção concluída!");
                    break;

                case 5:
                    System.out.print("Digite o elemento para remover todas ocorrências: ");
                    int elementoOcorrencias = scanner.nextInt();
                    fila.removerTodasOcorrencias(elementoOcorrencias);
                    limparTela();
                    break;

                case 6:
                    limparTela();
                    System.out.println("Fila vazia? " + (fila.estaVazia() ? "Sim" : "Não"));
                    break;

                case 7:
                    System.out.print("Digite o elemento a buscar: ");
                    int elementoBuscar = scanner.nextInt();
                    boolean encontrado = fila.buscarElemento(elementoBuscar);
                    limparTela();
                    System.out.println(
                            "Elemento " + elementoBuscar + " " + (encontrado ? "encontrado" : "não encontrado"));
                    break;

                case 8:
                    fila.ordenarCrescente();
                    limparTela();
                    System.out.println("Fila ordenada em ordem crescente!");
                    break;

                case 9:
                    fila.ordenarDecrescente();
                    limparTela();
                    System.out.println("Fila ordenada em ordem decrescente!");
                    break;

                case 10:
                    limparTela();
                    System.out.println("Quantidade de elementos na fila: " + fila.quantidadeElementos());
                    break;

                case 11:
                    System.out.print("Digite o elemento a ser editado: ");
                    int antigo = scanner.nextInt();
                    System.out.print("Digite o novo valor: ");
                    int novo = scanner.nextInt();
                    fila.editarElemento(antigo, novo);
                    limparTela();
                    System.out.println("Elemento editado com sucesso!");
                    break;

                case 12:
                    fila.limpar();
                    System.out.println("Fila limpa com sucesso!");
                    System.out.print("Digite o valor do novo primeiro elemento: ");
                    int novoPrimeiro = scanner.nextInt();
                    fila.inserirElemento(novoPrimeiro);
                    limparTela();
                    break;

                case 13:
                    limparTela();
                    System.out.println("=== ELEMENTOS DA FILA ===");
                    fila.exibir();
                    break;

                case 14:
                    No primeiro = fila.obterPrimeiroElemento();
                    limparTela();
                    System.out.println("Primeiro elemento: " +
                            (primeiro != null ? primeiro.getConteudo() : "A fila está vazia"));
                    break;

                case 15:
                    No ultimo = fila.obterUltimoElemento();
                    limparTela();
                    System.out.println("Último elemento: " +
                            (ultimo != null ? ultimo.getConteudo() : "A fila está vazia"));
                    break;
                case 16:
                    limparTela();
                    System.out.println("Fila cheia? " + (fila.estaCheia() ? "Sim" : "Não"));
                    break;
                case 0:
                    sair = true;
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Por favor, digite um número entre 0 e 15.");
            }
        }
        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1. Inserir elemento");
        System.out.println("2. Inserir sequência de elementos");
        System.out.println("3. Remover elemento");
        System.out.println("4. Remover sequência de elementos");
        System.out.println("5. Remover todas ocorrências de um elemento");
        System.out.println("6. Verificar se fila está vazia");
        System.out.println("7. Buscar elemento");
        System.out.println("8. Ordenar em ordem crescente");
        System.out.println("9. Ordenar em ordem decrescente");
        System.out.println("10. Quantidade de elementos");
        System.out.println("11. Editar elemento");
        System.out.println("12. Limpar fila");
        System.out.println("13. Exibir fila");
        System.out.println("14. Obter primeiro elemento");
        System.out.println("15. Obter último elemento");
        System.out.println("16. Verificar se fila está cheia");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void limparTela() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
