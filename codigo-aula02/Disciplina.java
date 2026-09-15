/**
 * EC01007 - Estruturas de Dados - Aula 02
 * EXERCICIO EM SALA - esqueleto. Complete os metodos marcados com TODO.
 *
 * A classe representa uma turma com capacidade limitada.
 * Regras:
 *   - o codigo nao pode ser vazio e a capacidade tem de ser positiva;
 *   - matricular devolve true se o aluno entrou, false se a turma esta lotada;
 *   - vagas() informa quantos lugares ainda restam;
 *   - o arranjo interno nunca e exposto para fora da classe.
 */
public class Disciplina {

    private final String codigo;
    private String nome;
    private Aluno[] matriculados;
    private int quantidade;        // quantos ja entraram

    public Disciplina(String codigo, String nome, int capacidade) {
        // TODO validar codigo e capacidade antes de atribuir
        this.codigo = codigo;
        this.nome = nome;
        this.matriculados = new Aluno[capacidade];
        this.quantidade = 0;
    }

    /** Devolve true se o aluno entrou; false se a turma ja esta lotada. */
    public boolean matricular(Aluno a) {
        // TODO
        return false;
    }

    /** Quantos lugares ainda restam. */
    public int vagas() {
        // TODO
        return 0;
    }

    @Override
    public String toString() {
        // TODO algo como: EC01007 - Estruturas de Dados (38/50)
        return codigo;
    }

    public static void main(String[] args) {
        Disciplina d = new Disciplina("EC01007", "Estruturas de Dados", 3);
        System.out.println(d);
        System.out.println("vagas: " + d.vagas());

        System.out.println(d.matricular(new Aluno("202600001", "Maria")));
        System.out.println(d.matricular(new Aluno("202600002", "Joao")));
        System.out.println(d.matricular(new Aluno("202600003", "Ana")));
        System.out.println(d.matricular(new Aluno("202600004", "Pedro")));  // deve dar false

        System.out.println(d);
    }
}
