import model.FilaDinamica;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();
        FilaDinamica fila = new FilaDinamica(0);
        fila.inserirElemento(1);
        fila.inserirElemento(220);
        fila.inserirElemento(4);
        fila.inserirElemento(5);
 
        
        fila.exibir();
        System.out.println("___________________________");
        
        fila.ordenarCrescente();
        fila.exibir();
    }
}
