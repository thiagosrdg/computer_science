import java.util.Arrays;

public class SelectionSort {

    public void sort(int[] arr) {
        int n = arr.length;

        // a cada iteração, a parte [0..i-1] já está ordenada
        // buscamos o menor elemento na parte restante [i..n-1]
        for (int i = 0; i < n - 1; i++) {

            // assume que o menor da parte não ordenada está na posição i
            int indiceMenor = i;

            // percorre o restante do array para achar o verdadeiro menor
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            // só troca se o menor não for já o elemento na posição i
            if (indiceMenor != i) {
                int temp = arr[i];
                arr[i] = arr[indiceMenor];
                arr[indiceMenor] = temp;
            }

            System.out.println("Passo " + (i + 1) + ": " + Arrays.toString(arr));
        }
    }
}
