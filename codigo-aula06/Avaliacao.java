/**
 * EC01007 - Estruturas de Dados - Aula 06
 * A mesma hierarquia da aula passada, agora com DOIS papeis novos.
 *
 *   extends  -> nenhum: Avaliacao nao herda de ninguem
 *   implements Comparable -> sei me comparar com outra Avaliacao
 *   implements Exportavel -> sei virar uma linha de CSV
 *
 * Uma classe estende no maximo UMA classe, mas implementa QUANTAS
 * interfaces quiser. E por isso que os papeis vem como interface.
 */
import java.util.Locale;

public abstract class Avaliacao implements Comparable<Avaliacao>, Exportavel {

    private final String nome;
    private final double peso;

    protected Avaliacao(String nome, double peso) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("nome obrigatorio");
        if (peso <= 0 || peso > 10)
            throw new IllegalArgumentException("peso fora de 0 a 10: " + peso);
        this.nome = nome;
        this.peso = peso;
    }

    public String getNome() { return nome; }
    public double getPeso() { return peso; }

    public abstract double pontuacao();

    public boolean atingiuMetade() { return pontuacao() >= peso / 2; }

    // ---- o contrato de Comparable: a ordem NATURAL da classe ----
    @Override
    public int compareTo(Avaliacao outra) {
        return Double.compare(this.pontuacao(), outra.pontuacao());
    }

    // ---- o contrato de Exportavel ----
    @Override
    public String paraCSV() {
        return String.format(Locale.ROOT, "%s;%.2f", nome, pontuacao());
    }

    @Override
    public String toString() {
        return String.format(Locale.ROOT, "%-22s %4.2f / %4.2f", nome, pontuacao(), peso);
    }
}
