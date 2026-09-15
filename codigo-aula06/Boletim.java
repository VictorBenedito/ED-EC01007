/**
 * EC01007 - Estruturas de Dados - Aula 05
 * A MESMA coisa, com polimorfismo. Nenhum switch, nenhum campo "tipo".
 *
 * O laco abaixo nao sabe quais tipos de avaliacao existem -- e nunca
 * vai precisar saber. Acrescentar Seminario nao muda uma linha daqui.
 */
import java.util.Locale;

public class Boletim {

    private final String aluno;
    private final Avaliacao[] avaliacoes;

    public Boletim(String aluno, Avaliacao[] avaliacoes) {
        this.aluno = aluno;
        this.avaliacoes = avaliacoes;
    }

    public double notaFinal() {
        double total = 0;
        for (Avaliacao a : avaliacoes)   // tipo declarado: a superclasse
            total += a.pontuacao();      // executado: o metodo da subclasse
        return total;
    }

    public String conceito() {
        double nf = notaFinal();
        if (nf >= 9.0) return "EXCELENTE";
        if (nf >= 7.0) return "BOM";
        if (nf >= 5.0) return "REGULAR";
        return "INSUFICIENTE";
    }

    public void imprimir() {
        System.out.println("Boletim de " + aluno);
        for (Avaliacao a : avaliacoes)
            System.out.printf(Locale.ROOT, "  %s   %s%n", a,
                    a.atingiuMetade() ? "" : "<- abaixo da metade");
        System.out.printf(Locale.ROOT, "  %-22s %4.2f / 10.00   %s%n",
                "NOTA FINAL", notaFinal(), conceito());
    }

    public static void main(String[] args) {
        Avaliacao[] av = {
            new Prova("NP1", 2.5, 8.0),
            new Prova("NP2", 2.5, 7.0),
            new ListaExercicios("Listas 1 a 4", 2.0, 9.0, 1),
            new Projeto("Projeto final", 3.0, 1.4, 0.6, 0.7),
        };
        new Boletim("Maria da Silva", av).imprimir();
    }
}
