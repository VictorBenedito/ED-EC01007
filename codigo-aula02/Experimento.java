/**
 * EC01007 - Estruturas de Dados - Aula 02
 * O que o Java copia quando voce chama um metodo?
 */
public class Experimento {

    static void troca(int x) {          // x recebe uma COPIA do valor
        x = 99;
    }

    static void zera(int[] v) {         // v recebe uma COPIA da referencia
        v[0] = 99;
    }

    static void substitui(int[] v) {    // trocar a referencia local nao afeta o chamador
        v = new int[]{99, 99, 99};
    }

    public static void main(String[] args) {
        int n = 7;
        troca(n);
        System.out.println("primitivo depois de troca(n)   -> " + n);

        int[] nums = {7, 8, 9};
        zera(nums);
        System.out.println("array depois de zera(nums)     -> " + nums[0]);

        int[] outros = {7, 8, 9};
        substitui(outros);
        System.out.println("array depois de substitui(...) -> " + outros[0]);

        System.out.println();

        String a = new String("ED");
        String b = new String("ED");
        System.out.println("new String: a == b       -> " + (a == b));
        System.out.println("new String: a.equals(b)  -> " + a.equals(b));

        String c = "ED";
        String d = "ED";
        System.out.println("literal:    c == d       -> " + (c == d));

        Integer p = 127, q = 127;
        Integer r = 128, s = 128;
        System.out.println("Integer 127: p == q      -> " + (p == q));
        System.out.println("Integer 128: r == s      -> " + (r == s));
    }
}
