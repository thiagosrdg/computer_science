public class Main {

    public static void main(String[] args) {
        // Cria um objeto para acessar os métodos da outra classe.
        Metodos metodos = new Metodos();

        // Matrizes de exemplo usadas nos testes.
        int[][] matrizA = {
            { 2, 5, 8 },
            { 7, 11, 14 },
            { 18, 21, 23 }
        };

        int[][] matrizB = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };

        // Esta matriz não é quadrada, então serve para testar erros.
        int[][] matrizRetangular = {
            { 10, 12, 14 },
            { 16, 18, 20 }
        };

        // Imprime as duas matrizes completas.
        exibeTitulo("Matriz A");
        metodos.imprimeArray(matrizA);

        exibeTitulo("Matriz B");
        metodos.imprimeArray(matrizB);

        // Mostra apenas uma linha específica da matriz A.
        exibeTitulo("Linha 1 da matriz A");
        metodos.imprimeLinhaArray(matrizA, 1);
        System.out.println();

        // Mostra apenas uma coluna específica da matriz A.
        exibeTitulo("Coluna 2 da matriz A");
        metodos.imprimeColunaArray(matrizA, 2);

        // Tenta calcular a diagonal principal de uma matriz quadrada.
        exibeTitulo("Soma da diagonal principal da matriz B");
        try {
            System.out.println(metodos.somaDiagonalPrincipal(matrizB));
        } catch (MinhaExcecao e) {
            System.out.println("Erro: " + e);
        }

        // Aqui o método deve gerar erro, porque a matriz não é quadrada.
        exibeTitulo("Tentativa de somar a diagonal da matriz retangular");
        try {
            System.out.println(metodos.somaDiagonalPrincipal(matrizRetangular));
        } catch (MinhaExcecao e) {
            System.out.println("Erro: " + e);
        }

        // Busca os números pares e imprime somente as posições válidas do vetor.
        exibeTitulo("Numeros pares da matriz A");
        int[] pares = metodos.encontraPares(matrizA);
        imprimePrimeirosValores(pares, contaPares(matrizA));

        // Busca os números primos e imprime somente as posições válidas do vetor.
        exibeTitulo("Numeros primos da matriz A");
        int[] primos = metodos.encontraPrimos(matrizA);
        imprimePrimeirosValores(primos, contaPrimos(matrizA, metodos));

        // Calcula a média geral da matriz A.
        exibeTitulo("Media da matriz A");
        System.out.printf("%.2f%n", metodos.calculaMedia(matrizA));

        // Calcula uma média para cada linha.
        exibeTitulo("Media das linhas da matriz A");
        imprimeArrayDouble(metodos.calculaMediaLinhas(matrizA));

        // Calcula uma média para cada coluna.
        exibeTitulo("Media das colunas da matriz A");
        imprimeArrayDouble(metodos.calculaMediasColunas(matrizA));

        // Calcula a média considerando todas as posições das duas matrizes.
        exibeTitulo("Media entre as matrizes A e B");
        System.out.printf("%.2f%n", metodos.calculaMedia(matrizA, matrizB));

        // Soma todos os valores das duas matrizes.
        exibeTitulo("Soma de todos os elementos de A e B");
        System.out.println(metodos.somaArrays(matrizA, matrizB));

        // Soma as matrizes posição por posição.
        exibeTitulo("Soma das posicoes de A e B");
        try {
            int[][] somaMatrizes = metodos.somaPosicoesArrays(matrizA, matrizB);
            metodos.imprimeArray(somaMatrizes);
        } catch (MinhaExcecao e) {
            System.out.println("Erro: " + e);
        }

        // Neste caso a soma por posição falha, pois os tamanhos são diferentes.
        exibeTitulo("Tentativa de somar matrizes de tamanhos diferentes");
        try {
            metodos.somaPosicoesArrays(matrizA, matrizRetangular);
        } catch (MinhaExcecao e) {
            System.out.println("Erro: " + e);
        }
    }

    private static void exibeTitulo(String titulo) {
        // Só organiza a saída no console.
        System.out.println();
        System.out.println("----- " + titulo + " -----");
    }

    private static void imprimePrimeirosValores(int[] valores, int quantidade) {
        // Se nada foi encontrado, informa isso e encerra o método.
        if (valores == null || quantidade == 0) {
            System.out.println("Nenhum valor encontrado.");
            return;
        }

        // Imprime apenas a parte do vetor que realmente foi preenchida.
        for (int i = 0; i < quantidade; i++) {
            System.out.print(valores[i] + " ");
        }
        System.out.println();
    }

    private static void imprimeArrayDouble(double[] valores) {
        // Mostra cada valor com duas casas decimais.
        for (double valor : valores) {
            System.out.printf("%.2f ", valor);
        }
        System.out.println();
    }

    private static int contaPares(int[][] matriz) {
        // Conta quantos pares existem para saber até onde imprimir o vetor retornado.
        int quantidade = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] % 2 == 0) {
                    quantidade++;
                }
            }
        }

        return quantidade;
    }

    private static int contaPrimos(int[][] matriz, Metodos metodos) {
        // Conta quantos primos existem para saber até onde imprimir o vetor retornado.
        int quantidade = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (metodos.verificaPrimo(matriz[i][j])) {
                    quantidade++;
                }
            }
        }

        return quantidade;
    }
}
