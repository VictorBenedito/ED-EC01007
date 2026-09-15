/**
 * EC01007 - Estruturas de Dados - Aula 06
 * A MESMA lista de avaliacoes, ordenada de quatro formas diferentes,
 * sem que a classe Avaliacao mude uma linha entre uma ordem e outra.
 */
import java.util.Arrays;
import java.util.Comparator;

public class Ordenacao {

    static void mostrar(String titulo, Avaliacao[] av) {
        System.out.println(titulo);
        for (Avaliacao a : av) System.out.println("   " + a);
        System.out.println();
    }

    public static void main(String[] args) {
        Avaliacao[] av = {
            new Prova("NP1", 2.5, 8.0),
            new Prova("NP2", 2.5, 7.0),
            new ListaExercicios("Listas 1 a 4", 2.0, 9.0, 1),
            new Projeto("Projeto final", 3.0, 1.4, 0.6, 0.7),
        };

        mostrar("ordem original:", av);

        // 1) ordem NATURAL - definida pelo compareTo da propria classe
        Arrays.sort(av);
        mostrar("1) Arrays.sort(av)  -> por pontuacao (Comparable):", av);

        // 2) um juiz externo: por peso, do maior para o menor
        Arrays.sort(av, Comparator.comparingDouble(Avaliacao::getPeso).reversed());
        mostrar("2) por peso decrescente (Comparator):", av);

        // 3) outro juiz: em ordem alfabetica de nome
        Arrays.sort(av, Comparator.comparing(Avaliacao::getNome));
        mostrar("3) por nome (Comparator):", av);

        // 4) criterio composto: peso, e em caso de empate, o nome
        Arrays.sort(av, Comparator.comparingDouble(Avaliacao::getPeso)
                                  .thenComparing(Avaliacao::getNome));
        mostrar("4) por peso e, no empate, por nome:", av);

        // o papel Exportavel, que nada tem a ver com ordenacao
        System.out.println("exportando para CSV:");
        System.out.println("   " + av[0].cabecalhoCSV());
        for (Avaliacao a : av) System.out.println("   " + a.paraCSV());
    }
}
