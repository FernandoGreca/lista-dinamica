import model.FilaDinamica;

public class MainFilaDinamica {
    public static void main(String[] args) {
        // Criando uma fila dinâmica com um elemento inicial
        FilaDinamica fila = new FilaDinamica(10);

        // Inserindo elementos na fila
        fila.inserirElemento(20);
        fila.inserirElemento(30);
        fila.inserirElemento(40);
        fila.inserirElemento(50);
        
        System.out.println("Elementos na fila após inserções:");
        fila.exibir();
        
        // Inserindo uma sequência de elementos
        Integer[] elementos = {60, 70, 80};
        fila.inserirSequencia(elementos);
        
        System.out.println("\nElementos na fila após inserir sequência:");
        fila.exibir();
        
        // Verificando a quantidade de elementos
        System.out.println("\nQuantidade de elementos na fila: " + fila.quantidadeElementos());
        
        // Editando um elemento
        fila.editarElemento(30, 35);
        System.out.println("\nFila após edição do elemento 30 para 35:");
        fila.exibir();
        
        // Obtendo o primeiro e o último elemento
        System.out.println("\nPrimeiro elemento: " + fila.obterPrimeiroElemento().getConteudo());
        System.out.println("Último elemento: " + fila.obterUltimoElemento().getConteudo());
        
        // Testando se a fila está vazia
        System.out.println("\nA fila está vazia? " + fila.estaVazia());
        
        // Limpando a fila
        fila.limpar();
        System.out.println("\nFila após limpeza:");
        fila.exibir();
    }
}
