/**
 * EC01007 - Estruturas de Dados - Aula 06 - ATIVIDADE PRATICA
 *
 * Escreva os dois comparadores marcados com TODO. Rode e confira
 * a ordem que aparece: o main ja imprime o resultado esperado ao lado.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Comparadores {

    // TODO 1: ordenar da MAIOR para a MENOR pontuacao.
    //         Dica: Comparator.comparingDouble(...).reversed()
    static Comparator<Avaliacao> porPontuacaoDecrescente() {
        return (a, b) -> 0;          // TODO
    }

    // TODO 2: ordenar pelo APROVEITAMENTO, isto e, pontuacao dividida
    //         pelo peso. Uma prova 8/10 com peso 2,5 rende 0,8 de
    //         aproveitamento, igual a uma lista 8/10 com peso 2,0.
    static Comparator<Avaliacao> porAproveitamento() {
        return (a, b) -> 0;          // TODO
    }

    public static void main(String[] args) {
        Avaliacao[] av = {
            new Prova("NP1", 2.5, 8.0),
            new Prova("NP2", 2.5, 7.0),
            new ListaExercicios("Listas 1 a 4", 2.0, 9.0, 1),
            new Projeto("Projeto final", 3.0, 1.4, 0.6, 0.7),
        };

        Arrays.sort(av, porPontuacaoDecrescente());
        System.out.println("1) por pontuacao decrescente   (esperado: Projeto, NP1, NP2, Listas)");
        for (Avaliacao a : av) System.out.println("   " + a);

        Arrays.sort(av, porAproveitamento());
        System.out.println();
        System.out.println("2) por aproveitamento crescente (esperado: NP2, Listas, NP1, Projeto)");
        for (Avaliacao a : av)
            System.out.printf(Locale.ROOT, "   %-22s aproveitamento %.2f%n", a.getNome(), a.pontuacao()/a.getPeso());
    }
}
