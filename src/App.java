import model.FilaDinamica;
import model.No;

public class App {
    public static void main(String[] args) {
        // 1. Teste do construtor
        System.out.println("1. Criando fila com elemento inicial 10");
        FilaDinamica fila = new FilaDinamica(10);
        fila.exibir();
        System.out.println("Quantidade de elementos: " + fila.quantidadeElementos());
        System.out.println("----------------------------------");

        // 2. Teste de inserção de elementos
        System.out.println("2. Inserindo elementos 20, 30, 40");
        fila.inserirElemento(20);
        fila.inserirElemento(30);
        fila.inserirElemento(40);
        fila.exibir();
        System.out.println("Quantidade de elementos: " + fila.quantidadeElementos());
        System.out.println("----------------------------------");

        // 3. Teste de inserção de sequência
        System.out.println("3. Inserindo sequência [50, 60, 70]");
        Integer[] sequencia1 = {50, 60, 70};
        fila.inserirSequencia(sequencia1);
        fila.exibir();
        System.out.println("Quantidade de elementos: " + fila.quantidadeElementos());
        System.out.println("----------------------------------");

        // 4. Teste de remoção de elemento
        System.out.println("4. Removendo elemento 30");
        fila.removerElemento(30);
        fila.exibir();
        System.out.println("Quantidade de elementos: " + fila.quantidadeElementos());
        System.out.println("----------------------------------");

        // 5. Teste de remoção de sequência
        System.out.println("5. Removendo sequência [20, 50]");
        Integer[] sequencia2 = {20, 50};
        fila.removerSequencia(sequencia2);
        fila.exibir();
        System.out.println("Quantidade de elementos: " + fila.quantidadeElementos());
        System.out.println("----------------------------------");

        // 6. Teste de inserção de elementos repetidos
        System.out.println("6. Inserindo elementos repetidos 10, 40, 10");
        fila.inserirElemento(10);
        fila.inserirElemento(40);
        fila.inserirElemento(10);
        fila.exibir();
        System.out.println("Quantidade de elementos: " + fila.quantidadeElementos());
        System.out.println("----------------------------------");

        // 7. Teste de remoção de todas ocorrências
        System.out.println("7. Removendo todas ocorrências de 10");
        fila.removerTodasOcorrencias(10);
        fila.exibir();
        System.out.println("Quantidade de elementos: " + fila.quantidadeElementos());
        System.out.println("----------------------------------");

        // 8. Teste de busca de elemento
        System.out.println("8. Buscando elementos 40 e 99");
        System.out.println("Busca por 40: " + fila.buscarElemento(40));
        System.out.println("Busca por 99: " + fila.buscarElemento(99));
        System.out.println("----------------------------------");

        // 9. Teste de ordenação crescente
        System.out.println("9. Ordenando em ordem crescente");
        fila.ordenarCrescente();
        fila.exibir();
        System.out.println("----------------------------------");

        // 10. Teste de ordenação decrescente
        System.out.println("10. Ordenando em ordem decrescente");
        fila.ordenarDecrescente();
        fila.exibir();
        System.out.println("----------------------------------");

        // 11. Teste de edição de elemento
        System.out.println("11. Editando elemento 40 para 45");
        fila.editarElemento(40, 45);
        fila.exibir();
        System.out.println("----------------------------------");

        // 12. Teste de obter primeiro e último elementos
        System.out.println("12. Obtendo primeiro e último elementos");
        No primeiro = fila.obterPrimeiroElemento();
        No ultimo = fila.obterUltimoElemento();
        System.out.println("Primeiro elemento: " + (primeiro != null ? primeiro.getConteudo() : "null"));
        System.out.println("Último elemento: " + (ultimo != null ? ultimo.getConteudo() : "null"));
        System.out.println("----------------------------------");

        // 13. Teste de verificação se está vazia
        System.out.println("13. Verificando se a fila está vazia");
        System.out.println("Está vazia? " + fila.estaVazia());
        System.out.println("----------------------------------");

        // 14. Teste de limpeza da fila
        System.out.println("14. Limpando a fila");
        fila.limpar();
        fila.exibir();
        System.out.println("Está vazia? " + fila.estaVazia());
        System.out.println("Está cheia? " + fila.estaCheia());
        System.out.println("Quantidade de elementos: " + fila.quantidadeElementos());
        System.out.println("----------------------------------");

        // 15. Teste com fila vazia
        System.out.println("15. Testando operações com fila vazia");
        fila.removerElemento(10); // Tentativa de remoção
        fila.buscarElemento(20);  // Tentativa de busca
        fila.ordenarCrescente();  // Tentativa de ordenação
        fila.ordenarDecrescente(); // Tentativa de ordenação
        System.out.println("----------------------------------");
    }
}
