import java.util.Arrays;

public class InsertionSort {

    public void sort(int[] arr) {
        int n = arr.length;

        // começa no índice 1 porque o primeiro elemento já está "na mão" ordenado
        for (int i = 1; i < n; i++) {

            // guarda o elemento atual que será inserido no lugar certo
            int atual = arr[i];

            // j começa no elemento anterior ao atual e vai regredindo
            int j = i - 1;

            // empurra para a direita todos os elementos maiores que o atual,
            // abrindo espaço para inserir o atual no lugar correto
            while (j >= 0 && arr[j] > atual) {
                arr[j + 1] = arr[j];
                j--;
            }

            // insere o atual na posição correta encontrada
            arr[j + 1] = atual;

            System.out.println("Passo " + i + ": " + Arrays.toString(arr));
        }
    }
}
