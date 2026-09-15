/** Prova escrita: a nota de 0 a 10 e convertida para o peso. */
public class Prova extends Avaliacao {

    private final double notaBruta;   // 0 a 10

    public Prova(String nome, double peso, double notaBruta) {
        super(nome, peso);                       // a superclasse constroi a parte dela
        if (notaBruta < 0 || notaBruta > 10)
            throw new IllegalArgumentException("nota fora de 0 a 10: " + notaBruta);
        this.notaBruta = notaBruta;
    }

    @Override
    public double pontuacao() {
        return notaBruta / 10.0 * getPeso();
    }
}
