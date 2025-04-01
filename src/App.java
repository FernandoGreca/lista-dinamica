import model.FilaDinamica;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();
        FilaDinamica fila = new FilaDinamica(10);
        fila.inserirElemento(20);
        fila.inserirElemento(30);

        fila.exibir();
        System.out.println("___________________________");

        fila.ordenarDecrescente();
        fila.exibir();
    }
}
