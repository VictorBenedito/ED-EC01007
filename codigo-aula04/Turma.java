/**
 * EC01007 - Estruturas de Dados - Aula 04
 * A mesma turma, agora encapsulada.
 *
 * Reune tudo o que a aula viu: private, final, this, get/set com
 * validacao, membro static, enum e composicao.
 */
public class Turma {

    // ---- enum: um conjunto fechado de valores validos ----
    public enum Situacao { ABERTA, LOTADA, ENCERRADA }

    // ---- static: pertence a CLASSE, nao a cada objeto ----
    private static int turmasCriadas = 0;

    // ---- final: atribuido uma vez, no construtor, e nunca mais ----
    private final String codigo;
    private final int capacidade;

    private String nome;
    private final Aluno[] matriculados;   // composicao: a Turma TEM alunos
    private int quantidade;
    private Situacao situacao;

    public Turma(String codigo, String nome, int capacidade) {
        if (codigo == null || codigo.isBlank())
            throw new IllegalArgumentException("codigo obrigatorio");
        if (capacidade <= 0)
            throw new IllegalArgumentException("capacidade tem de ser positiva: " + capacidade);
        this.codigo = codigo;
        this.nome = nome;
        this.capacidade = capacidade;
        this.matriculados = new Aluno[capacidade];
        this.quantidade = 0;
        this.situacao = Situacao.ABERTA;
        turmasCriadas++;
    }

    // ---- consultas: leitura sem expor o interior ----
    public String getCodigo()    { return codigo; }
    public String getNome()      { return nome; }
    public int getCapacidade()   { return capacidade; }
    public int getQuantidade()   { return quantidade; }
    public Situacao getSituacao(){ return situacao; }
    public int vagas()           { return capacidade - quantidade; }

    // ---- o unico set, e mesmo assim validando ----
    public void setNome(String nome) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("nome nao pode ser vazio");
        this.nome = nome;
    }

    // ---- a unica porta de entrada de alunos ----
    public boolean matricular(Aluno a) {
        if (a == null) throw new IllegalArgumentException("aluno nulo");
        if (situacao != Situacao.ABERTA) return false;
        if (quantidade >= capacidade) return false;
        if (contem(a.getMatricula())) return false;      // regra que a v0 nao conseguia garantir
        matriculados[quantidade] = a;
        quantidade++;
        if (quantidade == capacidade) situacao = Situacao.LOTADA;
        return true;
    }

    public boolean contem(String matricula) {
        for (int i = 0; i < quantidade; i++)
            if (matriculados[i].getMatricula().equals(matricula)) return true;
        return false;
    }

    public void encerrar() { this.situacao = Situacao.ENCERRADA; }

    // ---- metodo static: pergunta sobre a classe, nao sobre um objeto ----
    public static int getTurmasCriadas() { return turmasCriadas; }

    @Override
    public String toString() {
        return String.format("%s - %s (%d/%d, %s)",
                codigo, nome, quantidade, capacidade, situacao);
    }

    public static void main(String[] args) {
        Turma t = new Turma("EC01007", "Estruturas de Dados", 2);
        System.out.println(t + "   vagas: " + t.vagas());

        t.matricular(new Aluno("202600001", "Maria"));
        System.out.println("apos 1 matricula   : " + t + "   vagas: " + t.vagas());

        t.matricular(new Aluno("202600002", "Joao"));
        System.out.println("apos 2 matriculas  : " + t + "   vagas: " + t.vagas());

        System.out.println("matricula repetida : " + t.matricular(new Aluno("202600001", "Maria")));
        System.out.println("turma lotada       : " + t.matricular(new Aluno("202600003", "Ana")));

        try {
            new Turma("EC01099", "Turma invalida", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("capacidade -5      : " + e.getMessage());
        }

        System.out.println("turmas criadas     : " + Turma.getTurmasCriadas());
    }
}
