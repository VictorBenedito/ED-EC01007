/**
 * EC01007 - Estruturas de Dados - Aula 06
 * Um papel que qualquer classe pode assumir, independente da hierarquia dela.
 *
 * Repare: nao diz NADA sobre ser uma avaliacao. Uma Turma, um Aluno ou um
 * relatorio poderiam implementar esta mesma interface.
 */
public interface Exportavel {

    /** Uma linha em formato CSV, sem quebra de linha no fim. */
    String paraCSV();

    /** O cabecalho correspondente. Tem implementacao padrao:
     *  quem nao quiser a sua, sobrescreve. */
    default String cabecalhoCSV() {
        return "nome;valor";
    }
}
