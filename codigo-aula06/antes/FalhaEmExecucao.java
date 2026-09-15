import java.util.Arrays;
public class FalhaEmExecucao {
    public static void main(String[] args) {
        Object[] av = {
            new Avaliacao("NP1", 8.0, 2.5),
            new Avaliacao("NP2", 7.0, 2.5)
        };
        Arrays.sort(av);   // compila
    }
}
