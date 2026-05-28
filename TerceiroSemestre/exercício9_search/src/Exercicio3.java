public class Exercicio3 {

    public static int pesquisaBinariaRecursiva(int[] vetor, int valor) {
        return buscar(vetor, valor, 0, vetor.length - 1);
    }

    private static int buscar(int[] vetor, int valor, int inicio, int fim) {
        if (inicio > fim)
            return -1;

        int meio = (inicio + fim) / 2;

        if (valor == vetor[meio])
            return meio;
        else if (valor < vetor[meio])
            return buscar(vetor, valor, inicio, meio - 1);
        else
            return buscar(vetor, valor, meio + 1, fim);
    }
}
