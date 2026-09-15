/**
 * EC01007 - Estruturas de Dados - Aula 05 - EXERCICIO 3
 * O teste da hierarquia: acrescentar um tipo novo de avaliacao
 * SEM tocar em Avaliacao, Prova, ListaExercicios, Projeto ou Boletim.
 *
 * Se voce precisou editar qualquer um deles, a hierarquia esta errada.
 */
public class Seminario extends Avaliacao {

    private final double conteudo, oratoria;
    private final boolean dentroDoTempo;

    public Seminario(String nome, double peso,
                     double conteudo, double oratoria, boolean dentroDoTempo) {
        super(nome, peso);
        this.conteudo = conteudo;
        this.oratoria = oratoria;
        this.dentroDoTempo = dentroDoTempo;
    }

    @Override
    public double pontuacao() {
        double base = conteudo + oratoria;
        return dentroDoTempo ? base : base * 0.9;   // 10% se estourar o tempo
    }

    public static void main(String[] args) {
        // o Boletim nao foi alterado -- e ja sabe lidar com Seminario
        Avaliacao[] av = {
            new Prova("NP1", 2.0, 8.0),
            new Prova("NP2", 2.0, 7.0),
            new ListaExercicios("Listas 1 a 4", 2.0, 9.0, 0),
            new Seminario("Seminario", 1.0, 0.6, 0.3, false),
            new Projeto("Projeto final", 3.0, 1.4, 0.6, 0.7),
        };
        new Boletim("Joao Pereira", av).imprimir();
    }
}
