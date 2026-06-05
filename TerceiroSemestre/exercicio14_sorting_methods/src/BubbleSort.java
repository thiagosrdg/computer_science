import java.util.Arrays;

public class BubbleSort {

    public void sort(int[] arr) {
        int n = arr.length;

        // cada passagem garante que o maior elemento ainda fora do lugar
        // "borbulha" até o fim — por isso o limite do j diminui com i
        for (int i = 0; i < n - 1; i++) {

            // compara cada par de vizinhos, mas ignora os já ordenados no fim
            for (int j = 0; j < n - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    // troca usando variável temporária para não perder nenhum valor
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            System.out.println("Passagem " + (i + 1) + ": " + Arrays.toString(arr));
        }
    }
}
