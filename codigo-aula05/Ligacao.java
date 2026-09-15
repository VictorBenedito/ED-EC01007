/**
 * EC01007 - Estruturas de Dados - Aula 05
 * Tres demonstracoes sobre ligacao dinamica e construtores.
 */
public class Ligacao {

    // ---------- 1) ordem dos construtores ----------
    static class Base {
        Base() { System.out.println("   construtor de Base"); }
    }
    static class Derivada extends Base {
        Derivada() {
            // super() implicito acontece AQUI, antes da proxima linha
            System.out.println("   construtor de Derivada");
        }
    }

    // ---------- 2) tipo declarado x tipo real ----------
    static class Animal {
        String falar() { return "..."; }
    }
    static class Cachorro extends Animal {
        @Override String falar() { return "au"; }
        String buscarBola()      { return "bola!"; }
    }

    public static void main(String[] args) {
        System.out.println("1) new Derivada():");
        new Derivada();

        System.out.println();
        System.out.println("2) tipo declarado x tipo real:");
        Animal a = new Cachorro();              // declarado Animal, real Cachorro
        System.out.println("   a.falar() -> " + a.falar() + "   (metodo do Cachorro)");
        System.out.println("   a.buscarBola() nao compila: o tipo DECLARADO manda no");
        System.out.println("   que pode ser chamado; o tipo REAL manda no que executa.");

        System.out.println();
        System.out.println("3) polimorfismo em um laco:");
        Animal[] bichos = { new Animal(), new Cachorro(), new Cachorro() };
        for (Animal x : bichos) System.out.println("   " + x.falar());

        System.out.println();
        System.out.println("4) o mesmo com as avaliacoes:");
        Avaliacao[] av = { new Prova("NP1", 2.5, 8.0),
                           new ListaExercicios("Lista", 2.0, 9.0, 1) };
        for (Avaliacao x : av)
            System.out.printf("   %s -> %.2f%n", x.getNome(), x.pontuacao());
    }
}
