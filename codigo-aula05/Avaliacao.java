/**
 * EC01007 - Estruturas de Dados - Aula 05
 * A superclasse abstrata da hierarquia de avaliacoes.
 *
 * abstract = nao existe "uma avaliacao generica". Existe uma prova,
 * uma lista, um projeto. A classe define o que TODAS tem em comum e
 * deixa em aberto o que cada uma calcula de forma diferente.
 */
public abstract class Avaliacao {

    private final String nome;
    private final double peso;      // quanto vale, de 0 a 10

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

    /** Quantos pontos esta avaliacao rendeu, de 0 ate getPeso().
     *  Cada subclasse calcula do seu jeito. */
    public abstract double pontuacao();

    /** Herdado por todas: nenhuma subclasse precisa reescrever. */
    public boolean atingiuMetade() {
        return pontuacao() >= peso / 2;
    }

    @Override
    public String toString() {
        return String.format("%-22s %4.2f / %4.2f", nome, pontuacao(), peso);
    }
}
