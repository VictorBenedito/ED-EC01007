/**
 * EC01007 - Estruturas de Dados - Aula 04
 * VERSAO SEM ENCAPSULAMENTO. Nao use isto como modelo.
 *
 * Todos os campos sao publicos: qualquer codigo, em qualquer lugar do
 * programa, pode escrever neles. A classe nao consegue defender
 * nenhuma regra sobre si mesma.
 */
public class TurmaAberta {

    public String codigo;
    public String nome;
    public int capacidade;
    public Aluno[] matriculados;
    public int quantidade;

    public TurmaAberta(String codigo, String nome, int capacidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.capacidade = capacidade;
        this.matriculados = new Aluno[capacidade];
        this.quantidade = 0;
    }

    public boolean matricular(Aluno a) {
        if (quantidade >= capacidade) return false;
        matriculados[quantidade] = a;
        quantidade++;
        return true;
    }

    public int vagas() {
        return capacidade - quantidade;
    }

    @Override
    public String toString() {
        return codigo + " - " + nome + " (" + quantidade + "/" + capacidade + ")";
    }
}
