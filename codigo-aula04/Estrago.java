/**
 * EC01007 - Estruturas de Dados - Aula 04
 * Quatro estragos que campos publicos permitem.
 * Rode antes de consertar a classe.
 */
public class Estrago {
    public static void main(String[] args) {
        TurmaAberta t = new TurmaAberta("EC01007", "Estruturas de Dados", 3);
        t.matricular(new Aluno("202600001", "Maria"));
        System.out.println("estado inicial      : " + t + "   vagas: " + t.vagas());

        // ESTRAGO 1 - alguem escreve direto no contador
        t.quantidade = 100;
        System.out.println("1) quantidade = 100 : " + t + "   vagas: " + t.vagas());

        // ESTRAGO 2 - alguem troca a capacidade depois de criada
        t.quantidade = 1;
        t.capacidade = -5;
        System.out.println("2) capacidade = -5  : " + t + "   vagas: " + t.vagas());

        // ESTRAGO 3 - alguem apaga um aluno do arranjo sem avisar a turma
        t.capacidade = 3;
        t.matriculados[0] = null;
        System.out.println("3) matriculados[0] = null -> a turma ainda diz ter " + t.quantidade + " aluno");
        try {
            System.out.println("   lendo o aluno 0: " + t.matriculados[0].getNome());
        } catch (NullPointerException e) {
            System.out.println("   NullPointerException ao ler o aluno 0");
        }

        // ESTRAGO 4 - o codigo da turma muda no meio do semestre
        t.codigo = "OUTRA COISA";
        System.out.println("4) codigo trocado   : " + t);
    }
}
