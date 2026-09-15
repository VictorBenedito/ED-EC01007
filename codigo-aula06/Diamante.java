/**
 * EC01007 - Estruturas de Dados - Aula 06
 * Por que Java permite implementar N interfaces e estender so 1 classe.
 *
 * O problema classico (o "diamante") e: se dois pais trazem CODIGO
 * diferente para o mesmo metodo, qual roda? Java evita a pergunta
 * proibindo herdar codigo de duas classes.
 *
 * Com default methods (Java 8+) o conflito voltou a ser possivel entre
 * interfaces -- e o compilador OBRIGA voce a resolver na mao.
 */
public class Diamante {

    interface Impressora {
        default String ligar() { return "impressora ligando"; }
    }

    interface Scanner {
        default String ligar() { return "scanner ligando"; }
    }

    // Sem o override abaixo, esta classe NAO COMPILA:
    //   "class Multifuncional inherits unrelated defaults for ligar()"
    static class Multifuncional implements Impressora, Scanner {
        @Override
        public String ligar() {
            // voce escolhe, ou combina os dois:
            return Impressora.super.ligar() + " + " + Scanner.super.ligar();
        }
    }

    // Sem default, nao ha conflito nenhum: so contratos, sem codigo.
    interface Ligavel   { String estado(); }
    interface Reciclavel{ String material(); }

    static class Lampada implements Ligavel, Reciclavel {
        public String estado()   { return "acesa"; }
        public String material() { return "vidro"; }
    }

    public static void main(String[] args) {
        System.out.println("1) dois defaults conflitantes, resolvidos na mao:");
        System.out.println("   " + new Multifuncional().ligar());

        System.out.println();
        System.out.println("2) duas interfaces sem codigo: nenhum conflito possivel");
        Lampada l = new Lampada();
        System.out.println("   estado=" + l.estado() + "  material=" + l.material());

        System.out.println();
        System.out.println("3) uma variavel pode ver o mesmo objeto por papeis diferentes:");
        Ligavel    porPapelA = l;
        Reciclavel porPapelB = l;
        System.out.println("   como Ligavel    -> " + porPapelA.estado());
        System.out.println("   como Reciclavel -> " + porPapelB.material());
    }
}
