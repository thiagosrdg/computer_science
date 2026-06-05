import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr;

        System.out.println("=== Bubble Sort ===");
        arr = new int[]{4, -3, 18, 22, 50, 1, 47, -29};
        System.out.println("Inicial: " + Arrays.toString(arr));
        new BubbleSort().sort(arr);
        System.out.println("Final:   " + Arrays.toString(arr));

        System.out.println("\n=== Insertion Sort ===");
        arr = new int[]{4, -3, 18, 22, 50, 1, 47, -29};
        System.out.println("Inicial: " + Arrays.toString(arr));
        new InsertionSort().sort(arr);
        System.out.println("Final:   " + Arrays.toString(arr));

        System.out.println("\n=== Selection Sort ===");
        arr = new int[]{4, -3, 18, 22, 50, 1, 47, -29};
        System.out.println("Inicial: " + Arrays.toString(arr));
        new SelectionSort().sort(arr);
        System.out.println("Final:   " + Arrays.toString(arr));

        System.out.println("\n=== Exercício 4 — Ordenação de Placas ===");

        // array fixo com o exemplo do exercício
        // resultado esperado: AAF 3212 | AAF 9984 | ABC 1874 | DJ 8835 | XIJ 2943
        Placa[] placas = {
            new Placa("ABC", "1874"),
            new Placa("AAF", "9984"),
            new Placa("XIJ", "2943"),
            new Placa("AAF", "3212"),
            new Placa("DJ",  "8835")
        };

        OrdenaPlaca op = new OrdenaPlaca();
        op.ordena(placas);

        for (Placa p : placas)
            System.out.println(p);
    }
}
