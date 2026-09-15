/** Lista avaliativa: perde 20% do valor por dia util de atraso, ate 3 dias. */
public class ListaExercicios extends Avaliacao {

    private final double notaBruta;
    private final int diasAtraso;

    public ListaExercicios(String nome, double peso, double notaBruta, int diasAtraso) {
        super(nome, peso);
        this.notaBruta = notaBruta;
        this.diasAtraso = Math.max(0, diasAtraso);
    }

    @Override
    public double pontuacao() {
        if (diasAtraso > 3) return 0;            // depois de 3 dias uteis, zero
        double fator = 1.0 - 0.20 * diasAtraso;
        return notaBruta / 10.0 * getPeso() * fator;
    }
}
