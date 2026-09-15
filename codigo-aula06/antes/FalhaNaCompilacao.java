import java.util.*;
public class FalhaNaCompilacao {
    public static void main(String[] args) {
        List<Avaliacao> lista = new ArrayList<>();
        lista.add(new Avaliacao("NP1", 8.0, 2.5));
        Collections.sort(lista);   // nao compila
    }
}
