/**
 * EC01007 - Estruturas de Dados - Aula 05
 * VERSAO SEM HERANCA. E o codigo que a gente escreve antes de conhecer
 * polimorfismo -- e o que a aula de hoje vai apagar.
 *
 * Repare no que acontece quando chega um tipo novo de avaliacao:
 * e preciso mexer em TODOS os switch deste arquivo.
 */
public class BoletimComSwitch {

    // um "tipo" guardado como texto, e campos que so servem para alguns tipos
    static class Item {
        String tipo;          // "PROVA", "LISTA" ou "PROJETO"
        String nome;
        double peso;
        double notaBruta;     // so PROVA e LISTA usam
        int diasAtraso;       // so LISTA usa
        double cod, doc, apr; // so PROJETO usa
    }

    static double pontuacao(Item i) {
        switch (i.tipo) {
            case "PROVA":
                return i.notaBruta / 10.0 * i.peso;
            case "LISTA":
                if (i.diasAtraso > 3) return 0;
                return i.notaBruta / 10.0 * i.peso * (1 - 0.20 * i.diasAtraso);
            case "PROJETO":
                return i.cod + i.doc + i.apr;
            default:
                throw new IllegalArgumentException("tipo desconhecido: " + i.tipo);
        }
    }

    static boolean atingiuMetade(Item i) {
        return pontuacao(i) >= i.peso / 2;      // outro switch escondido aqui dentro
    }

    static String descrever(Item i) {
        switch (i.tipo) {                       // e mais um
            case "PROVA":   return "Prova " + i.nome;
            case "LISTA":   return "Lista " + i.nome;
            case "PROJETO": return "Projeto " + i.nome;
            default:        return i.nome;
        }
    }

    public static void main(String[] args) {
        Item p = new Item();
        p.tipo = "PROVA"; p.nome = "NP1"; p.peso = 2.5; p.notaBruta = 8.0;
        System.out.println(descrever(p) + " -> " + pontuacao(p));
        System.out.println("um tipo novo obrigaria a mexer em 3 switch deste arquivo");
    }
}
