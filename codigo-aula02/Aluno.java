/**
 * EC01007 - Estruturas de Dados - Aula 02
 * A primeira classe da disciplina: estado, construtor, encapsulamento e
 * comportamento.
 */
public class Aluno {

    // ---- estado: os campos guardam o que o objeto sabe sobre si ----
    private final String matricula; // final: nao muda depois de criado
    private String nome;
    private double[] notas; // as quatro avaliacoes, de 0 a 10

    // ---- construtor: garante que nenhum Aluno nasce invalido ----
    public Aluno(String matricula, String nome) {
        if (matricula == null || matricula.isBlank())
            throw new IllegalArgumentException("matricula obrigatoria");
        this.matricula = matricula;
        this.nome = nome;
        this.notas = new double[4];
    }

    // ---- encapsulamento: o mundo de fora fala por metodos, nunca com os campos
    // ----
    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("nome nao pode ser vazio");
        this.nome = nome;
    }

    // ---- comportamento: o que o objeto sabe FAZER ----
    public void lancarNota(int indice, double valor) {
        if (indice < 0 || indice >= notas.length)
            throw new IndexOutOfBoundsException("indice invalido: " + indice);
        if (valor < 0 || valor > 10)
            throw new IllegalArgumentException("nota fora de 0 a 10");
        notas[indice] = valor;
    }

    public double media() {
        double soma = 0;
        for (double n : notas)
            soma += n;
        return soma / notas.length;
    }

    public boolean aprovado() {
        return media() >= 5.0;
    }

    // @Override
    // public String toString() {
    // return String.format("%s - %s (media %.1f, %s)",
    // matricula, nome, media(), aprovado() ? "aprovado" : "reprovado");
    // }

    // ---- programa de teste ----
    public static void main(String[] args) {
        Aluno a = new Aluno("202600001", "Maria da Silva");
        a.lancarNota(0, 8.5);
        a.lancarNota(1, 7.0);
        a.lancarNota(2, 9.0);
        a.lancarNota(3, 6.5);
        System.out.println(a);

        Aluno b = new Aluno("202600002", "Joao Pereira");
        b.lancarNota(0, 4.0);
        b.lancarNota(1, 3.5);
        b.lancarNota(2, 5.0);
        b.lancarNota(3, 4.5);
        System.out.println(b);

        try {
            b.lancarNota(9, 5.0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("erro: " + e.getMessage());
        }
    }
}
