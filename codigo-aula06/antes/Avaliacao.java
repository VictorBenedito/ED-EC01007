// Avaliacao ANTES de implementar Comparable - so para ver as duas falhas.
public class Avaliacao {
    private final String nome;
    private final double nota, peso;
    public Avaliacao(String nome, double nota, double peso) {
        this.nome = nome; this.nota = nota; this.peso = peso;
    }
    public double pontuacao() { return nota * peso / 10.0; }
    public String toString() { return nome; }
}
