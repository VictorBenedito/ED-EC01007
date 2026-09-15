/** EC01007 - Aula 06 - GABARITO da atividade pratica. */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class ComparadoresGabarito {

    static Comparator<Avaliacao> porPontuacaoDecrescente() {
        return Comparator.comparingDouble(Avaliacao::pontuacao).reversed();
    }

    static Comparator<Avaliacao> porAproveitamento() {
        return Comparator.comparingDouble(a -> a.pontuacao() / a.getPeso());
    }

    public static void main(String[] args) {
        Avaliacao[] av = {
            new Prova("NP1", 2.5, 8.0),
            new Prova("NP2", 2.5, 7.0),
            new ListaExercicios("Listas 1 a 4", 2.0, 9.0, 1),
            new Projeto("Projeto final", 3.0, 1.4, 0.6, 0.7),
        };
        Arrays.sort(av, porPontuacaoDecrescente());
        System.out.println("1) por pontuacao decrescente:");
        for (Avaliacao a : av) System.out.println("   " + a);

        Arrays.sort(av, porAproveitamento());
        System.out.println();
        System.out.println("2) por aproveitamento crescente:");
        for (Avaliacao a : av)
            System.out.printf(Locale.ROOT, "   %-22s %.2f%n", a.getNome(), a.pontuacao()/a.getPeso());
    }
}
