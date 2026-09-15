import java.util.*;

/**
 * EC01007 - Estruturas de Dados - Aula 1
 * O mesmo problema, duas estruturas: quanto custa a escolha?
 *
 * Compile e rode:   javac Busca.java  &&  java -Xmx2g Busca
 * Os tempos variam de maquina para maquina — o que nao varia
 * e a ordem de grandeza da diferenca entre O(n) e O(log n).
 */
public class Busca {

    // Busca linear: percorre tudo, posicao por posicao.  ->  O(n)
    static int buscaLinear(int[] v, int alvo) {
        for (int i = 0; i < v.length; i++)
            if (v[i] == alvo) return i;
        return -1;
    }

    // Busca binaria: descarta metade a cada passo. Exige o vetor ORDENADO.  ->  O(log n)
    static int buscaBinaria(int[] v, int alvo) {
        int ini = 0, fim = v.length - 1;
        while (ini <= fim) {
            int meio = (ini + fim) >>> 1;
            if (v[meio] == alvo) return meio;
            if (v[meio] < alvo) ini = meio + 1;
            else fim = meio - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 10_000_000, consultas = 2_000;
        int[] v = new int[n];
        for (int i = 0; i < n; i++) v[i] = i * 2;   // ja ordenado
        Random r = new Random(42);
        int[] alvos = new int[consultas];
        for (int i = 0; i < consultas; i++) alvos[i] = r.nextInt(n) * 2;

        // aquecimento da JVM
        for (int i = 0; i < 50; i++) { buscaLinear(v, alvos[i]); buscaBinaria(v, alvos[i]); }

        long t0 = System.nanoTime();
        for (int alvo : alvos) buscaLinear(v, alvo);
        long tLinear = System.nanoTime() - t0;

        t0 = System.nanoTime();
        for (int alvo : alvos) buscaBinaria(v, alvo);
        long tBinaria = System.nanoTime() - t0;

        double msL = tLinear / 1e6 / consultas;
        double usB = tBinaria / 1e3 / consultas;
        System.out.printf("n = %,d elementos, %,d consultas%n", n, consultas);
        System.out.printf("Busca linear  : %8.3f ms por consulta%n", msL);
        System.out.printf("Busca binaria : %8.3f us por consulta%n", usB);
        System.out.printf("Razao         : %,.0f vezes mais rapida%n", (msL * 1000) / usB);
        System.out.printf("Comparacoes   : linear ~%,d   binaria ~%d%n",
                n / 2, (int) Math.ceil(Math.log(n) / Math.log(2)));
    }
}
