/** Projeto final: tres componentes que somam o peso total. */
public class Projeto extends Avaliacao {

    private final double codigo, documentacao, apresentacao;

    public Projeto(String nome, double peso,
                   double codigo, double documentacao, double apresentacao) {
        super(nome, peso);
        this.codigo = codigo;
        this.documentacao = documentacao;
        this.apresentacao = apresentacao;
    }

    @Override
    public double pontuacao() {
        return codigo + documentacao + apresentacao;
    }

    /** So o Projeto tem isto. Nao esta na superclasse. */
    public String detalhamento() {
        return String.format("codigo %.1f + doc %.1f + apresentacao %.1f",
                codigo, documentacao, apresentacao);
    }
}
